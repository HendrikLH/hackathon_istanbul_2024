
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.time.OffsetDateTime;
import java.util.Set;


/**
 * Booking details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_BookingOption )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BookingOption
    extends LogisticsObject
{

    /**
     * Information about the Booking Times of a privded Booking Option
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingTimes)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingTimes bookingTimes;
    /**
     * Reference to the operating carrier
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_carrier)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Carrier carrier;
    /**
     * Reference to the Carrier product if known
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_carrierProduct)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CarrierProduct carrierProduct;
    /**
     * Reference to the BookingOptionRequest the information of the LogisticsObject is detailling
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_forBookingOptionRequest)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingOptionRequest forBookingOptionRequest;
    /**
     * Reference to the Booking Request the of the Booking Option
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_forBookingRequest)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    @Exclude
    protected BookingRequest forBookingRequest;
    /**
     * Price of the Booking (if different from the offer)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_price)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Price price;
    /**
     * Remarks related to specific stations in the routing (e.g. Embargo in XXX)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_stationRemarks)
    protected Set<StationRemarks> stationRemarks;
    /**
     * Status of the Booking Option
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_statusBookingOption)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingOptionStatus statusBookingOption;
    /**
     * Reference to the Transport Legs of the proposed routing
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_transportLegs)
    protected Set<TransportLegs> transportLegs;
    /**
     * Reference to unit preferences of the request (e.g. kg or cm)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_unitsPreference)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected UnitsPreference unitsPreference;
    /**
     * Additional infromation related to the Booking Option, e.g. sales details
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_additionalInformation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String additionalInformation;
    /**
     * Description of the alternatives proposed that do not match the Booking Option Request
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_alternatives)
    protected Set<String> alternatives;
    /**
     * Date and time of beginning of offer validity
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_offerValidFrom)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime offerValidFrom;
    /**
     * Date and time of end of offer validity
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_offerValidTo)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime offerValidTo;
    /**
     * Indicates if the Booking Option is a match to the Booking Option Request preferences
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_requestMatch)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean requestMatch;

    public void setBookingTimes(BookingTimes bookingTimes) {
        this.bookingTimes = bookingTimes;
    }

    public BookingTimes getBookingTimes() {
        return bookingTimes;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrierProduct(CarrierProduct carrierProduct) {
        this.carrierProduct = carrierProduct;
    }

    public CarrierProduct getCarrierProduct() {
        return carrierProduct;
    }

    public void setForBookingOptionRequest(BookingOptionRequest forBookingOptionRequest) {
        this.forBookingOptionRequest = forBookingOptionRequest;
    }

    public BookingOptionRequest getForBookingOptionRequest() {
        return forBookingOptionRequest;
    }

    public void setForBookingRequest(BookingRequest forBookingRequest) {
        this.forBookingRequest = forBookingRequest;
    }

    public BookingRequest getForBookingRequest() {
        return forBookingRequest;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public void setStationRemarks(Set<StationRemarks> stationRemarks) {
        this.stationRemarks = stationRemarks;
    }

    public Set<StationRemarks> getStationRemarks() {
        return stationRemarks;
    }

    public void setStatusBookingOption(BookingOptionStatus statusBookingOption) {
        this.statusBookingOption = statusBookingOption;
    }

    public BookingOptionStatus getStatusBookingOption() {
        return statusBookingOption;
    }

    public void setTransportLegs(Set<TransportLegs> transportLegs) {
        this.transportLegs = transportLegs;
    }

    public Set<TransportLegs> getTransportLegs() {
        return transportLegs;
    }

    public void setUnitsPreference(UnitsPreference unitsPreference) {
        this.unitsPreference = unitsPreference;
    }

    public UnitsPreference getUnitsPreference() {
        return unitsPreference;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAlternatives(Set<String> alternatives) {
        this.alternatives = alternatives;
    }

    public Set<String> getAlternatives() {
        return alternatives;
    }

    public void setOfferValidFrom(OffsetDateTime offerValidFrom) {
        this.offerValidFrom = offerValidFrom;
    }

    public OffsetDateTime getOfferValidFrom() {
        return offerValidFrom;
    }

    public void setOfferValidTo(OffsetDateTime offerValidTo) {
        this.offerValidTo = offerValidTo;
    }

    public OffsetDateTime getOfferValidTo() {
        return offerValidTo;
    }

    public void setRequestMatch(Boolean requestMatch) {
        this.requestMatch = requestMatch;
    }

    public Boolean getRequestMatch() {
        return requestMatch;
    }

}
