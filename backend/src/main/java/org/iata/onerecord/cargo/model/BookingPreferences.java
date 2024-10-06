
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import cz.cvut.kbss.jopa.vocabulary.RDFS;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


/**
 * BookingPreferences details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_BookingPreferences )
@SuperBuilder
@EqualsAndHashCode
public class BookingPreferences
    implements Serializable
{

    @Id(generated = true)
    protected String id;
    @OWLAnnotationProperty(iri = RDFS.LABEL)
    protected String name;
    @OWLAnnotationProperty(iri = cz.cvut.kbss.jopa.vocabulary.DC.Elements.DESCRIPTION)
    protected String description;
    @Types
    protected Set<String> types;
    @Properties
    protected Map<String, Set<String>> properties;
    /**
     * Type of aircraft to be used if any specific requirements (e.g. Pure freighter, etc.)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_aircraftPossibilityCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected AircraftPossibilityCode aircraftPossibilityCode;
    /**
     * Locations of excluded Via Points
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_excludedViaPoints)
    protected Set<Location> excludedViaPoints;
    /**
     * Locations or stations to included in the routing
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_includedViaPoints)
    protected Set<Location> includedViaPoints;
    /**
     * Maximum number of segments for the transportation of the goods. 1 means direct flight
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_maxSegments)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer maxSegments;
    /**
     * When part of the Request it refers to the preferred Transport ID from the customer. When part of the BookingOption (offer or actual booking) it refers to the expected Transport ID or flight
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_preferredTransportId)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String preferredTransportId;
    /**
     * Reference to a price reference if existing (e.g. Allotment number, contract reference, etc.)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_priceReferenceId)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String priceReferenceId;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setProperties(Map<String, Set<String>> properties) {
        this.properties = properties;
    }

    public Map<String, Set<String>> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return ((((("BookingPreferences {"+ name)+"<")+ id)+">")+"}");
    }

    public void setAircraftPossibilityCode(AircraftPossibilityCode aircraftPossibilityCode) {
        this.aircraftPossibilityCode = aircraftPossibilityCode;
    }

    public AircraftPossibilityCode getAircraftPossibilityCode() {
        return aircraftPossibilityCode;
    }

    public void setExcludedViaPoints(Set<Location> excludedViaPoints) {
        this.excludedViaPoints = excludedViaPoints;
    }

    public Set<Location> getExcludedViaPoints() {
        return excludedViaPoints;
    }

    public void setIncludedViaPoints(Set<Location> includedViaPoints) {
        this.includedViaPoints = includedViaPoints;
    }

    public Set<Location> getIncludedViaPoints() {
        return includedViaPoints;
    }

    public void setMaxSegments(Integer maxSegments) {
        this.maxSegments = maxSegments;
    }

    public Integer getMaxSegments() {
        return maxSegments;
    }

    public void setPreferredTransportId(String preferredTransportId) {
        this.preferredTransportId = preferredTransportId;
    }

    public String getPreferredTransportId() {
        return preferredTransportId;
    }

    public void setPriceReferenceId(String priceReferenceId) {
        this.priceReferenceId = priceReferenceId;
    }

    public String getPriceReferenceId() {
        return priceReferenceId;
    }

}
