package com.lhcargo_lhind_jettainer.hackathon_istanbul.service.impl;


import com.lhcargo_lhind_jettainer.hackathon_istanbul.config.KeycloakProperties;
import com.lhcargo_lhind_jettainer.hackathon_istanbul.service.KeycloakService;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
@Slf4j
public class KeyCloakServiceImpl implements KeycloakService {

    private final @NonNull KeycloakProperties keycloakProperties;

    private String accessToken;

    private Instant accessTokenExpirationTime;

    private final WebClient webClient;

    @Autowired
    public KeyCloakServiceImpl(KeycloakProperties keycloakProperties) throws SSLException {
        this.keycloakProperties = keycloakProperties;

        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        HttpClient httpClient = HttpClient
                .create()
                .secure(t -> t.sslContext(sslContext));

        webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Override
    public String getAccessToken() {
        // if the token is set and valid for at least another 5 seconds, return it
        if (accessToken != null
                && accessTokenExpirationTime != null
                && accessTokenExpirationTime.isAfter(Instant.now().plusSeconds(5))) {
            return accessToken;
        }

        // otherwise, get a new token
        MultiValueMap<String, String> formData = constructJWTRequestFormData();
        log.info("Getting new access token");
        TokenResponse tokenResponse = null;
        try {
            tokenResponse = webClient.post()
                    .uri(keycloakProperties.getAccessTokenURL())
                    .body(BodyInserters.fromFormData(formData))
                    .accept(MediaType.ALL)
                    .retrieve()
                    .bodyToMono(TokenResponse.class)
                    .block();
        } catch (WebClientResponseException e) {
            log.error("failed to get access token from {} with status code {} message {}",
                    keycloakProperties.getAccessTokenURL(), e.getStatusCode(), e.getResponseBodyAsString());
        }

        if (tokenResponse != null) {
            log.info("Got new access token with expiration time: {}",
                    LocalDateTime.now().plusSeconds(tokenResponse.expires_in()));
            accessToken = tokenResponse.access_token();
            accessTokenExpirationTime = Instant.now().plusSeconds(tokenResponse.expires_in());
            return accessToken;
        } else {
            throw new RuntimeException("Could not get access token");
        }
    }

    private MultiValueMap<String, String> constructJWTRequestFormData() {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakProperties.getClientId());
        formData.add("client_secret", keycloakProperties.getClientSecret());
        if (keycloakProperties.getScope() != null && !keycloakProperties.getScope().isEmpty()) {
            formData.add("scope", keycloakProperties.getScope());
        }
        formData.add("grant_type", "client_credentials");
        return formData;
    }

    private record TokenResponse(
            String access_token,
            int expires_in,
            int refresh_expires_in,
            String token_type,
            int not_before_policy,
            String scope) {
    }
}
