
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.util.Set;


/**
 * Shipment details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Shipment )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Shipment
    extends LogisticsObject
{

    /**
     * Customs details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_customsInformation)
    protected Set<CustomsInformation> customsInformation;
    /**
     * Standard codes as defined by UNCEFACT and ICC that correspond to international rules for the interpretation of the most commonly used trade terms in different countries. UNECE recommendation n. 5 Incoterms 2.
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_incoterms)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CodeListElement incoterms;
    /**
     * Insurance details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_insurance)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Insurance insurance;
    /**
     * Information about other Parties involved depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_involvedParties)
    protected Set<Party> involvedParties;
    /**
     * References to the Pieces that are part of this Shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_pieces)
    protected Set<Piece> pieces;
    /**
     * Three-letter special handling code (SPH)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_specialHandlingCodes)
    protected Set<SpecialHandlingCode> specialHandlingCodes;
    /**
     * Dimensions of the whole shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_totalDimensions)
    protected Set<Dimensions> totalDimensions;
    /**
     * Total gross weight of the whole shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_totalGrossWeight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value totalGrossWeight;
    /**
     * Volumetric weight of the whole shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_totalVolumetricWeight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected VolumetricWeight totalVolumetricWeight;
    /**
     * Reference to the Waybill of the shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_waybill)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    @Exclude
    protected Waybill waybill;
    /**
     * Description of goods, for the BookingShipment the commodity list defined by Modernizing Cargo Distribution MCD working group can be used as a referential.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_goodsDescription)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String goodsDescription;
    /**
     * Strings to provide free text handling instructions such as SSR and OSI
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_textualHandlingInstructions)
    protected Set<String> textualHandlingInstructions;

    public void setCustomsInformation(Set<CustomsInformation> customsInformation) {
        this.customsInformation = customsInformation;
    }

    public Set<CustomsInformation> getCustomsInformation() {
        return customsInformation;
    }

    public void setIncoterms(CodeListElement incoterms) {
        this.incoterms = incoterms;
    }

    public CodeListElement getIncoterms() {
        return incoterms;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInvolvedParties(Set<Party> involvedParties) {
        this.involvedParties = involvedParties;
    }

    public Set<Party> getInvolvedParties() {
        return involvedParties;
    }

    public void setPieces(Set<Piece> pieces) {
        this.pieces = pieces;
    }

    public Set<Piece> getPieces() {
        return pieces;
    }

    public void setSpecialHandlingCodes(Set<SpecialHandlingCode> specialHandlingCodes) {
        this.specialHandlingCodes = specialHandlingCodes;
    }

    public Set<SpecialHandlingCode> getSpecialHandlingCodes() {
        return specialHandlingCodes;
    }

    public void setTotalDimensions(Set<Dimensions> totalDimensions) {
        this.totalDimensions = totalDimensions;
    }

    public Set<Dimensions> getTotalDimensions() {
        return totalDimensions;
    }

    public void setTotalGrossWeight(Value totalGrossWeight) {
        this.totalGrossWeight = totalGrossWeight;
    }

    public Value getTotalGrossWeight() {
        return totalGrossWeight;
    }

    public void setTotalVolumetricWeight(VolumetricWeight totalVolumetricWeight) {
        this.totalVolumetricWeight = totalVolumetricWeight;
    }

    public VolumetricWeight getTotalVolumetricWeight() {
        return totalVolumetricWeight;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setTextualHandlingInstructions(Set<String> textualHandlingInstructions) {
        this.textualHandlingInstructions = textualHandlingInstructions;
    }

    public Set<String> getTextualHandlingInstructions() {
        return textualHandlingInstructions;
    }

}
