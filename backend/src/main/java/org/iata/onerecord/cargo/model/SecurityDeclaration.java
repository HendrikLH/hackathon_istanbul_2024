
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.time.OffsetDateTime;
import java.util.Set;


/**
 * Security declaration details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_SecurityDeclaration )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SecurityDeclaration
    extends LogisticsObject
{

    /**
     * Exemption code - e.g. BIOM- Bio-Medical Samples
     * SMUS - small undersized shipments MAIL - mail
     * BIOM - bio-medical samples
     * DIPL - diplomatic bags or diplomatic mail
     * LFSM - life-saving materials NUCL - nuclear materials
     * TRNS - transfer or transshipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_groundsForExemption)
    protected Set<ScreeningExemption> groundsForExemption;
    /**
     * Name of person (or employee ID) who issued the security status
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_issuedBy)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Person issuedBy;
    /**
     * Reference to the Piece the document was issued for
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_issuedForPiece)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Piece issuedForPiece;
    /**
     * Any other regulated entity that accepts custody of the cargo and accepts the security status originally issued
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherRegulatedEntities)
    protected Set<RegulatedEntity> otherRegulatedEntities;
    /**
     * Regulated entity that tendered the consignment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_receivedFrom)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected RegulatedEntity receivedFrom;
    /**
     * Information about the accepting regulated entity of the Security Declaration
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_regulatedEntityAcceptor)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected RegulatedEntity regulatedEntityAcceptor;
    /**
     * Regulated entity issuing the Security Declaration
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_regulatedEntityIssuer)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected RegulatedEntity regulatedEntityIssuer;
    /**
     * Screening methods which have been used to secure the cargo
     * PHS – Physical Inspection and/or hand search
     * VCK - Visual check
     * XRY- X-ray equipment
     * EDS - Explosive detection system
     * EDD - Explosive detection dogs
     * ETD - Explosive trace detection equipment - particles or vapor
     * CMD - Cargo metal detection
     * AOM - Subjected to any other means: this entry should be followed by free text specifying what other mean was used to secure the cargo
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_screeningMethods)
    protected Set<ScreeningMethod> screeningMethods;
    /**
     * Security status indicator (CXML 1.13) - e.g. SPX- Cargo Secure for Passenger and All-Cargo Aircraft 
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_securityStatus)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected SecurityStatus securityStatus;
    /**
     * Any additional information that may be required by an ICAO Member State
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_additionalSecurityInformation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String additionalSecurityInformation;
    /**
     * Date and time when the security status was issued
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_issuedOn)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime issuedOn;
    /**
     * Other methods used to secure the cargo
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_otherScreeningMethods)
    protected Set<String> otherScreeningMethods;

    public void setGroundsForExemption(Set<ScreeningExemption> groundsForExemption) {
        this.groundsForExemption = groundsForExemption;
    }

    public Set<ScreeningExemption> getGroundsForExemption() {
        return groundsForExemption;
    }

    public void setIssuedBy(Person issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Person getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedForPiece(Piece issuedForPiece) {
        this.issuedForPiece = issuedForPiece;
    }

    public Piece getIssuedForPiece() {
        return issuedForPiece;
    }

    public void setOtherRegulatedEntities(Set<RegulatedEntity> otherRegulatedEntities) {
        this.otherRegulatedEntities = otherRegulatedEntities;
    }

    public Set<RegulatedEntity> getOtherRegulatedEntities() {
        return otherRegulatedEntities;
    }

    public void setReceivedFrom(RegulatedEntity receivedFrom) {
        this.receivedFrom = receivedFrom;
    }

    public RegulatedEntity getReceivedFrom() {
        return receivedFrom;
    }

    public void setRegulatedEntityAcceptor(RegulatedEntity regulatedEntityAcceptor) {
        this.regulatedEntityAcceptor = regulatedEntityAcceptor;
    }

    public RegulatedEntity getRegulatedEntityAcceptor() {
        return regulatedEntityAcceptor;
    }

    public void setRegulatedEntityIssuer(RegulatedEntity regulatedEntityIssuer) {
        this.regulatedEntityIssuer = regulatedEntityIssuer;
    }

    public RegulatedEntity getRegulatedEntityIssuer() {
        return regulatedEntityIssuer;
    }

    public void setScreeningMethods(Set<ScreeningMethod> screeningMethods) {
        this.screeningMethods = screeningMethods;
    }

    public Set<ScreeningMethod> getScreeningMethods() {
        return screeningMethods;
    }

    public void setSecurityStatus(SecurityStatus securityStatus) {
        this.securityStatus = securityStatus;
    }

    public SecurityStatus getSecurityStatus() {
        return securityStatus;
    }

    public void setAdditionalSecurityInformation(String additionalSecurityInformation) {
        this.additionalSecurityInformation = additionalSecurityInformation;
    }

    public String getAdditionalSecurityInformation() {
        return additionalSecurityInformation;
    }

    public void setIssuedOn(OffsetDateTime issuedOn) {
        this.issuedOn = issuedOn;
    }

    public OffsetDateTime getIssuedOn() {
        return issuedOn;
    }

    public void setOtherScreeningMethods(Set<String> otherScreeningMethods) {
        this.otherScreeningMethods = otherScreeningMethods;
    }

    public Set<String> getOtherScreeningMethods() {
        return otherScreeningMethods;
    }

}
