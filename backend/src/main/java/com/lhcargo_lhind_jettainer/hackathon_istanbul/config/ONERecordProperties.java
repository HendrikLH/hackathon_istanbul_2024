package com.lhcargo_lhind_jettainer.hackathon_istanbul.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@Getter
@Setter
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "onerecord")
public class ONERecordProperties {

    @NotEmpty
    private String companyOrganizationId;

    @NotEmpty
    private String companyActorId;

    @NotEmpty
    private Server server;

    @Getter
    @Setter
    public static class Server {

        // URL where the 1R Server is reachable for the shipment-adapter
        @NotEmpty
        private String url;

        // URL where the 1R Server is reachable for external users. This is used for generating IDs of logistics objects
        @NotEmpty
        private String externalUrl;

        @NotEmpty
        private String authHeaderPrefix;
    }

}

