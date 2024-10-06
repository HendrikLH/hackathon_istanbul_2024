
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.util.Set;


/**
 * Booking object refers to a confirmed booking
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Booking )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Booking
    extends LogisticsService
{

    /**
     * Reference to the Booking Request
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingRequest)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingRequest bookingRequest;
    /**
     * Status of the Booking
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingStatus)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingStatus bookingStatus;
    /**
     * Reference to the Waybill object
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_issuedForWaybill)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    @Exclude
    protected Waybill issuedForWaybill;
    /**
     * References to BookingOptionRequests that request to update the Booking
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_updateBookingOptionRequests)
    protected Set<BookingOptionRequest> updateBookingOptionRequests;
    /**
     * House or Master Waybill unique identifier
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_waybillNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String waybillNumber;
    /**
     * Prefix used for the Waybill Number. Refer to IATA Airlines Codes
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_waybillPrefix)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String waybillPrefix;

    public void setBookingRequest(BookingRequest bookingRequest) {
        this.bookingRequest = bookingRequest;
    }

    public BookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setIssuedForWaybill(Waybill issuedForWaybill) {
        this.issuedForWaybill = issuedForWaybill;
    }

    public Waybill getIssuedForWaybill() {
        return issuedForWaybill;
    }

    public void setUpdateBookingOptionRequests(Set<BookingOptionRequest> updateBookingOptionRequests) {
        this.updateBookingOptionRequests = updateBookingOptionRequests;
    }

    public Set<BookingOptionRequest> getUpdateBookingOptionRequests() {
        return updateBookingOptionRequests;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillPrefix(String waybillPrefix) {
        this.waybillPrefix = waybillPrefix;
    }

    public String getWaybillPrefix() {
        return waybillPrefix;
    }

}