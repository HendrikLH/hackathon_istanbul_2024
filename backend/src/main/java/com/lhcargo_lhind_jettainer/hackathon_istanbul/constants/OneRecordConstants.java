package com.lhcargo_lhind_jettainer.hackathon_istanbul.constants;

import com.lhcargo_lhind_jettainer.hackathon_istanbul.config.ONERecordProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.iata.onerecord.cargo.model.Actor;
import org.iata.onerecord.cargo.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OneRecordConstants {

    private final @NonNull ONERecordProperties oneRecordProperties;

    @Bean(name = "lufthansaCargoOrganization")
    public Organization lufthansaCargoOrganization() {
        return Organization.builder()
                .id(oneRecordProperties.getCompanyOrganizationId())
                .build();
    }

    @Bean(name = "lufthansaCargoActor")
    public Actor lufthansaCargoActor() {
        return Actor.builder()
                .id(oneRecordProperties.getCompanyActorId())
                .associatedOrganization(Organization.builder().id(oneRecordProperties.getCompanyOrganizationId()).build())
                .build();
    }
}
