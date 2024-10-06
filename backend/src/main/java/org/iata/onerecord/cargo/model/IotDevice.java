
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.io.Serializable;
import java.util.Set;


/**
 * IoT Device details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_IotDevice )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class IotDevice
    extends PhysicalLogisticsObject
    implements Serializable
{

    /**
     * Reference to the PhysicalLogisticsObject the IotDevice is attached to
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_attachedToObject)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected PhysicalLogisticsObject attachedToObject;
    /**
     * Reference to the sensors linked to the device
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_connectedSensors)
    protected Set<Sensor> connectedSensors;
    /**
     * Manufacturing company details and contacts
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_manufacturer)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Company manufacturer;
    /**
     * Natural language description if required
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_description)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String description;
    /**
     * Commercial denomination of the device
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_deviceModel)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String deviceModel;
    /**
     * Human-understandable name of object depending on the context
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_name)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String name;
    /**
     * Serial number that allows to uniquely identify the object
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_serialNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String serialNumber;

    public void setAttachedToObject(PhysicalLogisticsObject attachedToObject) {
        this.attachedToObject = attachedToObject;
    }

    public PhysicalLogisticsObject getAttachedToObject() {
        return attachedToObject;
    }

    public void setConnectedSensors(Set<Sensor> connectedSensors) {
        this.connectedSensors = connectedSensors;
    }

    public Set<Sensor> getConnectedSensors() {
        return connectedSensors;
    }

    public void setManufacturer(Company manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Company getManufacturer() {
        return manufacturer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

}
