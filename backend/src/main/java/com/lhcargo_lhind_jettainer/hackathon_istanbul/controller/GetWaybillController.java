package com.lhcargo_lhind_jettainer.hackathon_istanbul.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhcargo_lhind_jettainer.hackathon_istanbul.service.OneRecordServerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iata.onerecord.cargo.model.LogisticsEvent;
import org.iata.onerecord.cargo.model.LogisticsObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@Tag(name = "REST endpoint to get Waybill as LogisticsObject from ESB")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetWaybillController {

    private final @NonNull ObjectMapper jacksonObjectMapper;

    private final @NonNull OneRecordServerService oneRecordServerService;

    @GetMapping(value = "/getWaybill")
    public ResponseEntity<String> getWaybill(
            @RequestParam(value = "logisticsEventId")  String logisticsEventId)
            throws Exception {
        log.info("Received GET request for Waybill {}", logisticsEventId);


        // get Logistics Events for the uld -> uld-AKE65850LH
        LogisticsEvent logisticsEvent = oneRecordServerService.getLogisticsEvent("uld-AKE65849LH");
        //String waybill = oneRecordServerService.getSensor(sensorId);

        // return http response
        String waybillString = jacksonObjectMapper.writeValueAsString(logisticsEvent);
        //waybillString = JsonLdUtils.removeNotRequiredTypesFromJsonLd(waybillString);

        log.info("End of /getWaybill request. Returning value.");
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("application/ld+json"))
                .body(waybillString);
    }
}
