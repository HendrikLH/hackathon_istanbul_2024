package com.lhcargo_lhind_jettainer.hackathon_istanbul.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhcargo_lhind_jettainer.hackathon_istanbul.config.ONERecordProperties;
import com.lhcargo_lhind_jettainer.hackathon_istanbul.model.CARGO;
import com.lhcargo_lhind_jettainer.hackathon_istanbul.service.KeycloakService;
import com.lhcargo_lhind_jettainer.hackathon_istanbul.service.OneRecordServerService;
import com.lhcargo_lhind_jettainer.hackathon_istanbul.util.JsonLdUtils;
import cz.cvut.kbss.jsonld.JsonLd;
import cz.cvut.kbss.jsonld.exception.JsonLdDeserializationException;
import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.iata.onerecord.api.model.Collection;
import org.iata.onerecord.cargo.model.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service to interact with ONE Record server
 */
@Lazy
@Service
@Slf4j
public class OneRecordServerServiceImpl implements OneRecordServerService {

    private final @NonNull KeycloakService keycloakService;

    private final @NonNull ONERecordProperties oneRecordProperties;

    private final @NonNull ObjectMapper jacksonObjectMapper;


    private WebClient webClient;

    public OneRecordServerServiceImpl(@NonNull KeycloakService keycloakService,
                                      @NonNull ONERecordProperties oneRecordProperties,
                                      @NonNull ObjectMapper jacksonObjectMapper) throws SSLException {
        this.keycloakService = keycloakService;
        this.oneRecordProperties = oneRecordProperties;
        this.jacksonObjectMapper = jacksonObjectMapper;

        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        HttpClient httpClient = HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000) // Connection timeout, 15 seconds
                .responseTimeout(Duration.ofMillis(30000)) // Response timeout, 15 seconds
                .secure(t -> t.sslContext(sslContext));

        webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16MB
                .build();
    }

    @Override
    public LogisticsObject getLogisticsObject(String id, Class<? extends LogisticsObject> logisticsObjectType) throws JsonProcessingException, JsonLdDeserializationException {
        return null;
    }

    @Override
    public LogisticsObject getLogisticsObject(String id, Class<? extends LogisticsObject> logisticsObjectType, boolean embedded) throws JsonProcessingException, JsonLdDeserializationException {
        return null;
    }

    @Override
    public URI createLogisticsObject(LogisticsObject logisticsObject) {
        return null;
    }

    @Override
    public URI createLogisticsObject(LogisticsObject logisticsObject, boolean grantPublicAccess) throws WebClientResponseException {
        return null;
    }

    @Override
    public URI createLogisticsEventBKD(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventRCSP(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventRCSA(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventMANP(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventMANA(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventDEPP(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventDEPA(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventARRP(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventARRA(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventRCFP(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventRCFA(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventNFDP(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventNFDA(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventDLVP(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public URI createLogisticsEventDLVA(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public String getSensor(String id) {
        LogisticsObject logisticsObject = null;
        String response = null;
        keycloakService.getAccessToken();

        // build query URL
        String logisticsObjectID = String.format(
                "%s/logistics-objects/%s",
                oneRecordProperties.getServer().getExternalUrl(),
                id);
        String url = String.format(
                "%s/logistics-objects/%s",
                oneRecordProperties.getServer().getUrl(),
                id);

        try {
            log.info("from ONE Record server '{}'", url);

            Mono<Object> responseMono = getWebClient(HttpMethod.GET, url)
                    .exchangeToMono(clientResponse -> {
                        if (clientResponse.statusCode().is2xxSuccessful()) {
                            return clientResponse.bodyToMono(String.class);
                        } else if (clientResponse.statusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
                            return Mono.empty();
                        } else {
                            return clientResponse.createError();
                        }
                    });

            if (responseMono != null && responseMono.block() != null) {
                response = (String) responseMono.block();
            } else {
                log.debug("LogisticsObject not found on ONE Record server '{}'", logisticsObjectID);
                return null;
            }
        } catch (WebClientResponseException e) {
            log.error("Error while retrieving LogisticsObject from ONE Record server '{}': {}",
                    url, e.getResponseBodyAsString());
            throw e;
        }
        /*if (response != null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseJsonNode = objectMapper.readTree(response);
                JsonNode resolvedGraph = JsonLdUtils.resolveGraphIfPresent(responseJsonNode, logisticsObjectID);
                JsonLdUtils.enrichJsonWithTypes(resolvedGraph, CARGO.getInstance());
                // extract all logisticsObjectIds and cache them, because if the logisticsObject
                // has more than @id and @type, it exists on the ONE Record serer
                Set<String> logisticsObjectIds = JsonLdUtils.extractLinkableIds(resolvedGraph);
                //logisticsObjectIds.forEach(this::cacheLogisticsObjectId);

                logisticsObject = jacksonObjectMapper.treeToValue(resolvedGraph, Sensor.class);
            } catch (JsonLdDeserializationException | IOException e) {
                log.error("Error while deserializing LogisticsObject from ONE Record server '{}': {}",
                        url, e.getMessage());
                return null;
            }
        }*/
        if (logisticsObject != null) {
            // kind of safety net to make sure that the id of the successfully retrieved
            // logisticsObject is cached
            //this.cacheLogisticsObjectId(logisticsObject.getId());
        }

        return response;
    }

    @Override
    public LogisticsEvent getLogisticsEvent(String logisticsEventID) {
        String responseActual = null;
        String responsePlanned = null;
        String uri = "http://localhost:8080/logistics-objects/uld-AKE65850LH/logistics-events/f31abef7-2139-4875-949f-587c874b33cc";
        Mono<Object> responseMonoActual = getWebClient(HttpMethod.GET, uri)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        return clientResponse.bodyToMono(String.class);
                    } else if (clientResponse.statusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
                        return Mono.empty();
                    } else {
                        return clientResponse.createError();
                    }
                });

        String uriPlanned = "http://localhost:8080/logistics-objects/uld-AKE65850LH/logistics-events/4c0a79e5-228f-4805-a740-07649b31bd3c";
        Mono<Object> responseMonoPlanned = getWebClient(HttpMethod.GET, uriPlanned)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        return clientResponse.bodyToMono(String.class);
                    } else if (clientResponse.statusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
                        return Mono.empty();
                    } else {
                        return clientResponse.createError();
                    }
                });
        if (responseMonoActual != null && responseMonoActual.block() != null) {
            responseActual = (String) responseMonoActual.block();
        }

        if (responseMonoPlanned != null && responseMonoPlanned.block() != null) {
            responsePlanned = (String) responseMonoActual.block();
        }

        if (responseActual != null) {
            //ObjectMapper objectMapper = new ObjectMapper();
            //JsonNode responseJsonNode;
            //responseJsonNode = objectMapper.readTree(response);

            //JsonNode resolvedGraph = JsonLdUtils.resolveGraphIfPresent(responseJsonNode, logisticsEventID);
            //JsonLdUtils.enrichJsonWithTypes(resolvedGraph, CARGO.getInstance());

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Parse the JSON string
                JsonNode rootNodeActual = objectMapper.readTree(responseActual);
                JsonNode rootNodePlanned = objectMapper.readTree(responsePlanned);

                // Extract the "eventCode" and "eventTimeType" nodes
                JsonNode eventCodeNode = rootNodeActual.path("eventCode").path("@id");
                JsonNode eventTimeTypeNode = rootNodeActual.path("eventTimeType").path("@id");

                // Extract the required values
                String eventCodeValue = eventCodeNode.asText();
                String eventTimeTypeValue = eventTimeTypeNode.asText();

                // Extract "StatusCode_FOW" from "eventCodeValue"
                String statusCode = eventCodeValue.split("#")[1]; // Splitting by '#' and taking the second part
                System.out.println("Status Code: " + statusCode);

                // Extract "ACTUAL" from "eventTimeTypeValue"
                String actual = eventTimeTypeValue.split("#")[1]; // Splitting by '#' and taking the second part
                System.out.println("Actual: " + actual);


                // extract Planned Data

                // Extract the "eventCode" and "eventTimeType" nodes
                JsonNode eventCodeNodePlanned = rootNodePlanned.path("eventCode").path("@id");
                JsonNode eventTimeTypeNodeP = rootNodeActual.path("eventTimeType").path("@id");

                // Extract the required values
                String eventCodeValuePlanned = eventCodeNodePlanned.asText();
                String eventTimeTypeValuePlanned = eventTimeTypeNodeP.asText();

                // Extract "StatusCode_FOW" from "eventCodeValue"
                String statusCodePlanned = eventTimeTypeValuePlanned.split("#")[1]; // Splitting by '#' and taking the second part
                System.out.println("Status Code: " + statusCode);

                // Extract "PLANNED" from "eventTimeTypeValue"
                String planned = eventTimeTypeValuePlanned.split("#")[1]; // Splitting by '#' and taking the second part
                System.out.println("Planned: " + planned);




                if (statusCode.equals("StatusCode_FOW") && actual.equals("ACTUAL")) {
                    if (eventCodeValuePlanned.equals(eventCodeValue)) {

                    }
                    System.out.println("The event code is 'StatusCode_FOW' and the event time type is 'ACTUAL'");
                } else {
                    System.out.println("The event code is not 'StatusCode_FOW' and the event time type is not 'ACTUAL'");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // return jacksonObjectMapper.treeToValue(responseJsonNode, LogisticsEvent.class);
            return null;
        }
        return null;
    }

    @Override
    public Collection getLogisticsEvents(Set<String> logisticsObjectIDs) {
        return null;
    }

    @Override
    public Waybill getWaybill(String logisticsObjectID, boolean embedded) {
        return null;
    }

    @Override
    public LogisticsObject createSensor(String id, Class<? extends LogisticsObject> logisticsObjectType) throws JsonProcessingException, JsonLdDeserializationException {
        return null;
    }

    @Override
    public List<URI> updateSensor(LogisticsObject updatedLogisticsObject) {
        return null;
    }

    @Override
    public URI getSensor(LogisticsObject logisticsObject) {
        return null;
    }

    @Override
    public LogisticsObject createIotDevice(String id, Class<? extends LogisticsObject> logisticsObjectType) throws JsonProcessingException, JsonLdDeserializationException {
        return null;
    }

    @Override
    public URI getIotDevice(LogisticsObject logisticsObject) {
        return null;
    }

    @Override
    public List<URI> updateIotDevice(LogisticsObject updatedLogisticsObject) {
        return null;
    }

    @Override
    public URI createLogisticsEventForULD(@NonNull LogisticsEvent event) {
        return null;
    }

    @Override
    public Collection getLogisticsEventsForULD(Set<String> logisticsObjectIDs) {
        return null;
    }

    private WebClient.RequestBodySpec getWebClient(HttpMethod method, String uri) {
        return webClient.method(method)
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, JsonLd.MEDIA_TYPE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + keycloakService.getAccessToken());
    }
}
