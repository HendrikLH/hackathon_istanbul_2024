
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
 * Geolocation details - e.g. for drones, automated vehicles
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Geolocation )
@SuperBuilder
@EqualsAndHashCode
public class Geolocation
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
     * Elevation from sea level - Change of data type to Value as of ontology v1.1
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_elevation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value elevation;
    /**
     * Location latitude decimal
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_latitude)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#double", max = 1)
    })
    protected Double latitude;
    /**
     * Location longitude decimal
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_longitude)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#double", max = 1)
    })
    protected Double longitude;

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
        return ((((("Geolocation {"+ name)+"<")+ id)+">")+"}");
    }

    public void setElevation(Value elevation) {
        this.elevation = elevation;
    }

    public Value getElevation() {
        return elevation;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return longitude;
    }

}
