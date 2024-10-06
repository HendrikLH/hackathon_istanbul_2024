package com.lhcargo_lhind_jettainer.hackathon_istanbul.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.cvut.kbss.jsonld.exception.JsonLdDeserializationException;
import lombok.NonNull;
import org.iata.onerecord.api.model.Collection;
import org.iata.onerecord.cargo.model.LogisticsEvent;
import org.iata.onerecord.cargo.model.LogisticsObject;
import org.iata.onerecord.cargo.model.Waybill;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.net.URI;
import java.util.List;
import java.util.Set;

public interface OneRecordServerService {



    // get Logistics Objects
    LogisticsObject getLogisticsObject(String id, Class<? extends LogisticsObject> logisticsObjectType) throws JsonProcessingException, JsonLdDeserializationException;
    LogisticsObject getLogisticsObject(String id, Class<? extends LogisticsObject> logisticsObjectType, boolean embedded) throws JsonProcessingException, JsonLdDeserializationException;

    // create Logistics Objects
    URI createLogisticsObject(LogisticsObject logisticsObject);
    URI createLogisticsObject(LogisticsObject logisticsObject, boolean grantPublicAccess) throws WebClientResponseException;

    String getSensor(String id);

    LogisticsEvent getLogisticsEvent(String logisticsEventID);

    Collection getLogisticsEvents(Set<String> logisticsObjectIDs);

    // get Waybill
    Waybill getWaybill(String logisticsObjectID, boolean embedded);

    // create Sensor
    LogisticsObject createSensor(String id, Class<? extends LogisticsObject> logisticsObjectType) throws JsonProcessingException, JsonLdDeserializationException;
    //update Sensor
    List<URI> updateSensor(LogisticsObject updatedLogisticsObject);
    // get Sensor
    URI getSensor(LogisticsObject logisticsObject);

    // IOTDevice
    // create IOTDevice
    LogisticsObject createIotDevice(String id, Class<? extends LogisticsObject> logisticsObjectType) throws JsonProcessingException, JsonLdDeserializationException;
    // get IOTDevice
    URI getIotDevice(LogisticsObject logisticsObject);
    // update IOTDevice
    List<URI> updateIotDevice(LogisticsObject updatedLogisticsObject);

    // create Logistics Events for ULD
    URI createLogisticsEventForULD(@NonNull LogisticsEvent event);

    // get Logistics Events for ULD
    Collection getLogisticsEventsForULD(Set<String> logisticsObjectIDs);

    // create Measurement




    // create Logistics Events

    //BKD Actual
    URI createLogisticsEventBKD(@NonNull LogisticsEvent event);

    // RCS Planned
    URI createLogisticsEventRCSP(@NonNull LogisticsEvent event);

    // RCS Actual
    URI createLogisticsEventRCSA(@NonNull LogisticsEvent event);

    // MAN Planned
    URI createLogisticsEventMANP(@NonNull LogisticsEvent event);

    // MAN Actual
    URI createLogisticsEventMANA(@NonNull LogisticsEvent event);

    // DEP Planned
    URI createLogisticsEventDEPP(@NonNull LogisticsEvent event);

    // DEP Actual
    URI createLogisticsEventDEPA(@NonNull LogisticsEvent event);

    // ARR Planned
    URI createLogisticsEventARRP(@NonNull LogisticsEvent event);

    // ARR Actual
    URI createLogisticsEventARRA(@NonNull LogisticsEvent event);

    // RCF Planned
    URI createLogisticsEventRCFP(@NonNull LogisticsEvent event);

    // RCF Actual
    URI createLogisticsEventRCFA(@NonNull LogisticsEvent event);

    // NFD Planned
    URI createLogisticsEventNFDP(@NonNull LogisticsEvent event);

    // NFD Actual
    URI createLogisticsEventNFDA(@NonNull LogisticsEvent event);

    // DLV Planned
    URI createLogisticsEventDLVP(@NonNull LogisticsEvent event);

    // DLV Actual
    URI createLogisticsEventDLVA(@NonNull LogisticsEvent event);
}
