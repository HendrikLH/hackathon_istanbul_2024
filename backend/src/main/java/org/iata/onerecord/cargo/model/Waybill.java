
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.time.OffsetDateTime;
import java.util.Set;


/**
 * Waybill details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Waybill )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Waybill
    extends LogisticsObject
{

    /**
     * Reference to the arrival Location
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_arrivalLocation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location arrivalLocation;
    /**
     * Reference to the BillingDetails of the Waybill
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_billingDetails)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BillingDetails billingDetails;
    /**
     * One letter charge code as per bullet point 12 - data element 13 from AWB
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_carrierChargeCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected ChargeCode carrierChargeCode;
    /**
     * Location of individual or company involved in the movement of a consignment or Coded representation of a specific airport/city code
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_carrierDeclarationPlace)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location carrierDeclarationPlace;
    /**
     * Code indicating the origin of goods for Customs purposes (e.g. For goods in free circulation in the EU)
     * List to be provided by local authorities
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_customsOriginCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CodeListElement customsOriginCode;
    /**
     * The value of a shipment declared for carriage purposes
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_declaredValueForCarriage)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CurrencyValue declaredValueForCarriage;
    /**
     * The value of a shipment declared for customs purposes
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_declaredValueForCustoms)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CurrencyValue declaredValueForCustoms;
    /**
     * Reference to the depature Location
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_departureLocation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location departureLocation;
    /**
     * Charges levied at destination accruing to the last carrier, in destination currency
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_destinationCharges)
    protected Set<CurrencyValue> destinationCharges;
    /**
     * Refers to the Waybill(s) contained
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_houseWaybills)
    protected Set<Waybill> houseWaybills;
    /**
     * Information about other Parties involved depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_involvedParties)
    protected Set<Party> involvedParties;
    /**
     * Reference to the master Waybill if it is contained in one
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_masterWaybill)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Waybill masterWaybill;
    /**
     * Information about Other Charges applying to this Waybill
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherCharges)
    protected Set<OtherCharge> otherCharges;
    /**
     * Indicator whether the payment of Other Charges is to be made at origin (prepaid) or at destination (collect) as per bullet point 13 - data element 15a/15b from AWB
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherChargesIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected PrepaidCollectIndicator otherChargesIndicator;
    /**
     * Refers to the Booking
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_referredBookingOption)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Booking referredBookingOption;
    /**
     * One letter service code as per bullet point 18.4 - data element 22Z from AWB
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_serviceCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected ServiceCode serviceCode;
    /**
     * Reference to the Shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_shipment)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Shipment shipment;
    /**
     * Information about rates applying to this Waybill handled as line item
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_waybillLineItems)
    protected Set<WaybillLineItem> waybillLineItems;
    /**
     * Type of the Waybill: House, Direct or Master
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_waybillType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected WaybillType waybillType;
    /**
     * Indicator whether the payment for the Weight/Valuation is to be made at origin (prepaid) or at destination (collect) as per bullet point 13 - data element 14a/14b from AWB
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_weightValuationIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected PrepaidCollectIndicator weightValuationIndicator;
    /**
     * Indicates the details of accounting information. Free text e.g. PAYMENT BY CERTIFIED CHEQUE etc.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_accountingInformation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String accountingInformation;
    /**
     * Date upon which the certification is made by the carrier
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_carrierDeclarationDate)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime carrierDeclarationDate;
    /**
     * Contains the authentication of the Carrier
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_carrierDeclarationSignature)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String carrierDeclarationSignature;
    /**
     * Name of consignor signatory
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_consignorDeclarationSignature)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String consignorDeclarationSignature;
    /**
     * Conversion rate applied
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_destinationCurrencyRate)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#double", max = 1)
    })
    protected Double destinationCurrencyRate;
    /**
     * The check is a Modular 7 validation on the AWB number, recorded as a boolean.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_modularCheckNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean modularCheckNumber;
    /**
     * The shipper or its Agent may enter the appropriate optional shipping
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_shippingInfo)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String shippingInfo;
    /**
     * Optional shipping reference number if any
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_shippingRefNo)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String shippingRefNo;
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

    public void setArrivalLocation(Location arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public void setCarrierChargeCode(ChargeCode carrierChargeCode) {
        this.carrierChargeCode = carrierChargeCode;
    }

    public ChargeCode getCarrierChargeCode() {
        return carrierChargeCode;
    }

    public void setCarrierDeclarationPlace(Location carrierDeclarationPlace) {
        this.carrierDeclarationPlace = carrierDeclarationPlace;
    }

    public Location getCarrierDeclarationPlace() {
        return carrierDeclarationPlace;
    }

    public void setCustomsOriginCode(CodeListElement customsOriginCode) {
        this.customsOriginCode = customsOriginCode;
    }

    public CodeListElement getCustomsOriginCode() {
        return customsOriginCode;
    }

    public void setDeclaredValueForCarriage(CurrencyValue declaredValueForCarriage) {
        this.declaredValueForCarriage = declaredValueForCarriage;
    }

    public CurrencyValue getDeclaredValueForCarriage() {
        return declaredValueForCarriage;
    }

    public void setDeclaredValueForCustoms(CurrencyValue declaredValueForCustoms) {
        this.declaredValueForCustoms = declaredValueForCustoms;
    }

    public CurrencyValue getDeclaredValueForCustoms() {
        return declaredValueForCustoms;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setDestinationCharges(Set<CurrencyValue> destinationCharges) {
        this.destinationCharges = destinationCharges;
    }

    public Set<CurrencyValue> getDestinationCharges() {
        return destinationCharges;
    }

    public void setHouseWaybills(Set<Waybill> houseWaybills) {
        this.houseWaybills = houseWaybills;
    }

    public Set<Waybill> getHouseWaybills() {
        return houseWaybills;
    }

    public void setInvolvedParties(Set<Party> involvedParties) {
        this.involvedParties = involvedParties;
    }

    public Set<Party> getInvolvedParties() {
        return involvedParties;
    }

    public void setMasterWaybill(Waybill masterWaybill) {
        this.masterWaybill = masterWaybill;
    }

    public Waybill getMasterWaybill() {
        return masterWaybill;
    }

    public void setOtherCharges(Set<OtherCharge> otherCharges) {
        this.otherCharges = otherCharges;
    }

    public Set<OtherCharge> getOtherCharges() {
        return otherCharges;
    }

    public void setOtherChargesIndicator(PrepaidCollectIndicator otherChargesIndicator) {
        this.otherChargesIndicator = otherChargesIndicator;
    }

    public PrepaidCollectIndicator getOtherChargesIndicator() {
        return otherChargesIndicator;
    }

    public void setReferredBookingOption(Booking referredBookingOption) {
        this.referredBookingOption = referredBookingOption;
    }

    public Booking getReferredBookingOption() {
        return referredBookingOption;
    }

    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setWaybillLineItems(Set<WaybillLineItem> waybillLineItems) {
        this.waybillLineItems = waybillLineItems;
    }

    public Set<WaybillLineItem> getWaybillLineItems() {
        return waybillLineItems;
    }

    public void setWaybillType(WaybillType waybillType) {
        this.waybillType = waybillType;
    }

    public WaybillType getWaybillType() {
        return waybillType;
    }

    public void setWeightValuationIndicator(PrepaidCollectIndicator weightValuationIndicator) {
        this.weightValuationIndicator = weightValuationIndicator;
    }

    public PrepaidCollectIndicator getWeightValuationIndicator() {
        return weightValuationIndicator;
    }

    public void setAccountingInformation(String accountingInformation) {
        this.accountingInformation = accountingInformation;
    }

    public String getAccountingInformation() {
        return accountingInformation;
    }

    public void setCarrierDeclarationDate(OffsetDateTime carrierDeclarationDate) {
        this.carrierDeclarationDate = carrierDeclarationDate;
    }

    public OffsetDateTime getCarrierDeclarationDate() {
        return carrierDeclarationDate;
    }

    public void setCarrierDeclarationSignature(String carrierDeclarationSignature) {
        this.carrierDeclarationSignature = carrierDeclarationSignature;
    }

    public String getCarrierDeclarationSignature() {
        return carrierDeclarationSignature;
    }

    public void setConsignorDeclarationSignature(String consignorDeclarationSignature) {
        this.consignorDeclarationSignature = consignorDeclarationSignature;
    }

    public String getConsignorDeclarationSignature() {
        return consignorDeclarationSignature;
    }

    public void setDestinationCurrencyRate(Double destinationCurrencyRate) {
        this.destinationCurrencyRate = destinationCurrencyRate;
    }

    public Double getDestinationCurrencyRate() {
        return destinationCurrencyRate;
    }

    public void setModularCheckNumber(Boolean modularCheckNumber) {
        this.modularCheckNumber = modularCheckNumber;
    }

    public Boolean getModularCheckNumber() {
        return modularCheckNumber;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingRefNo(String shippingRefNo) {
        this.shippingRefNo = shippingRefNo;
    }

    public String getShippingRefNo() {
        return shippingRefNo;
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