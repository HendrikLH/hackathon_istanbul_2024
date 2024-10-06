
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.util.Set;


/**
 * Request object, refers to the Quote request or Booking request 
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_BookingOptionRequest )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BookingOptionRequest
    extends LogisticsObject
{

    /**
     * Reference to all Booking Options
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingOptions)
    protected Set<BookingOption> bookingOptions;
    /**
     * Reference to the Booking preferences
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingPreference)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingPreferences bookingPreference;
    /**
     * Reference to the BookingShipment if required
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingShipmentDetails)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingShipment bookingShipmentDetails;
    /**
     * Reference to the Booking to update
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingToUpdate)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Booking bookingToUpdate;
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
     * Information about other Parties involved depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_involvedParties)
    protected Set<Party> involvedParties;
    /**
     * Schedule preferences of the request
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_timePreferences)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingTimes timePreferences;
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
     * Indication if shipper is a Known Shipper as per TSA grant
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_knownShipper)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean knownShipper;

    public void setBookingOptions(Set<BookingOption> bookingOptions) {
        this.bookingOptions = bookingOptions;
    }

    public Set<BookingOption> getBookingOptions() {
        return bookingOptions;
    }

    public void setBookingPreference(BookingPreferences bookingPreference) {
        this.bookingPreference = bookingPreference;
    }

    public BookingPreferences getBookingPreference() {
        return bookingPreference;
    }

    public void setBookingShipmentDetails(BookingShipment bookingShipmentDetails) {
        this.bookingShipmentDetails = bookingShipmentDetails;
    }

    public BookingShipment getBookingShipmentDetails() {
        return bookingShipmentDetails;
    }

    public void setBookingToUpdate(Booking bookingToUpdate) {
        this.bookingToUpdate = bookingToUpdate;
    }

    public Booking getBookingToUpdate() {
        return bookingToUpdate;
    }

    public void setCarrierProduct(CarrierProduct carrierProduct) {
        this.carrierProduct = carrierProduct;
    }

    public CarrierProduct getCarrierProduct() {
        return carrierProduct;
    }

    public void setInvolvedParties(Set<Party> involvedParties) {
        this.involvedParties = involvedParties;
    }

    public Set<Party> getInvolvedParties() {
        return involvedParties;
    }

    public void setTimePreferences(BookingTimes timePreferences) {
        this.timePreferences = timePreferences;
    }

    public BookingTimes getTimePreferences() {
        return timePreferences;
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

    public void setKnownShipper(Boolean knownShipper) {
        this.knownShipper = knownShipper;
    }

    public Boolean getKnownShipper() {
        return knownShipper;
    }

}
