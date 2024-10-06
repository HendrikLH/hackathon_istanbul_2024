
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.io.Serializable;


/**
 * Unit Load Device details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_ULD )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ULD
    extends LoadingUnit
    implements Serializable
{

    /**
     * Contains three designator of demurrage code, refer to RP 1654 (BCC, HHH, XXX, ZZZ)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_demurrageCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected DemurrageCode demurrageCode;
    /**
     * ULD height or loading limitation code. Refer CXML Code List 1.47,  e.g. R - ULD Height above 244 centimetres
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_loadingIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected ULDLoadingIndicator loadingIndicator;
    /**
     * Contains two designator codes of ODLN or Operational Damage Limit Notices. ODLN code is used to define type of damage after visually check the serviceability of ULDs section 7, Standard Specifications 4/3 or 4/4 in ULD Regulations
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_odlnCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CodeListElement odlnCode;
    /**
     * Owner code of the ULD in aa, an or na format - owner can be an airline or leasing company
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_ownerCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CodeListElement ownerCode;
    /**
     * Designator of serviceablity condition e.g. SER or DAM 
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_serviceabilityCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected ULDConditionCode serviceabilityCode;
    /**
     * Standard Unit Load Device type code e.g. AKE - Certified Container - Contoured. Refer to IATA ULD Technical Manual
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_uldTypeCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CodeListElement uldTypeCode;
    /**
     * US / ATA Unit Load Device type code e.g. M2
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_ataDesignator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String ataDesignator;
    /**
     * Indicates if the ULD is Damaged
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_damageFlag)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean damageFlag;
    /**
     * Number of doors
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_numberOfDoors)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer numberOfDoors;
    /**
     * Number of fittings
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_numberOfFittings)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer numberOfFittings;
    /**
     * Number of nets
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_numberOfNets)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer numberOfNets;
    /**
     * Number of straps
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_numberOfStraps)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer numberOfStraps;
    /**
     * ULD seal number if applicable
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_sealNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String sealNumber;
    /**
     * Serial number that allows to uniquely identify the ULD
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_uldSerialNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String uldSerialNumber;

    public void setDemurrageCode(DemurrageCode demurrageCode) {
        this.demurrageCode = demurrageCode;
    }

    public DemurrageCode getDemurrageCode() {
        return demurrageCode;
    }

    public void setLoadingIndicator(ULDLoadingIndicator loadingIndicator) {
        this.loadingIndicator = loadingIndicator;
    }

    public ULDLoadingIndicator getLoadingIndicator() {
        return loadingIndicator;
    }

    public void setOdlnCode(CodeListElement odlnCode) {
        this.odlnCode = odlnCode;
    }

    public CodeListElement getOdlnCode() {
        return odlnCode;
    }

    public void setOwnerCode(CodeListElement ownerCode) {
        this.ownerCode = ownerCode;
    }

    public CodeListElement getOwnerCode() {
        return ownerCode;
    }

    public void setServiceabilityCode(ULDConditionCode serviceabilityCode) {
        this.serviceabilityCode = serviceabilityCode;
    }

    public ULDConditionCode getServiceabilityCode() {
        return serviceabilityCode;
    }

    public void setUldTypeCode(CodeListElement uldTypeCode) {
        this.uldTypeCode = uldTypeCode;
    }

    public CodeListElement getUldTypeCode() {
        return uldTypeCode;
    }

    public void setAtaDesignator(String ataDesignator) {
        this.ataDesignator = ataDesignator;
    }

    public String getAtaDesignator() {
        return ataDesignator;
    }

    public void setDamageFlag(Boolean damageFlag) {
        this.damageFlag = damageFlag;
    }

    public Boolean getDamageFlag() {
        return damageFlag;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfFittings(Integer numberOfFittings) {
        this.numberOfFittings = numberOfFittings;
    }

    public Integer getNumberOfFittings() {
        return numberOfFittings;
    }

    public void setNumberOfNets(Integer numberOfNets) {
        this.numberOfNets = numberOfNets;
    }

    public Integer getNumberOfNets() {
        return numberOfNets;
    }

    public void setNumberOfStraps(Integer numberOfStraps) {
        this.numberOfStraps = numberOfStraps;
    }

    public Integer getNumberOfStraps() {
        return numberOfStraps;
    }

    public void setSealNumber(String sealNumber) {
        this.sealNumber = sealNumber;
    }

    public String getSealNumber() {
        return sealNumber;
    }

    public void setUldSerialNumber(String uldSerialNumber) {
        this.uldSerialNumber = uldSerialNumber;
    }

    public String getUldSerialNumber() {
        return uldSerialNumber;
    }

}