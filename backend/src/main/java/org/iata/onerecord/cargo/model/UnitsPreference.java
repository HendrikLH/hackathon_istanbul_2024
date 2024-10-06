
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
 * UnitsPreference details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_UnitsPreference )
@SuperBuilder
@EqualsAndHashCode
public class UnitsPreference
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
     * Preferred unit for currency
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_currency)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CurrencyCode currency;
    /**
     * Preferred unit for measurement and dimensions
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_dimensionsUnit)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected DimensionsUnitCode dimensionsUnit;
    /**
     * Preferred unit for temperature
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_temperatureUnit)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected TemperatureUnitCode temperatureUnit;
    /**
     * Preferred unit for volume
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_volumeUnit)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected VolumeUnitCode volumeUnit;
    /**
     * Preferred unit for weight
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_weightUnit)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected WeightUnitCode weightUnit;

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
        return ((((("UnitsPreference {"+ name)+"<")+ id)+">")+"}");
    }

    public void setCurrency(CurrencyCode currency) {
        this.currency = currency;
    }

    public CurrencyCode getCurrency() {
        return currency;
    }

    public void setDimensionsUnit(DimensionsUnitCode dimensionsUnit) {
        this.dimensionsUnit = dimensionsUnit;
    }

    public DimensionsUnitCode getDimensionsUnit() {
        return dimensionsUnit;
    }

    public void setTemperatureUnit(TemperatureUnitCode temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public TemperatureUnitCode getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setVolumeUnit(VolumeUnitCode volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public VolumeUnitCode getVolumeUnit() {
        return volumeUnit;
    }

    public void setWeightUnit(WeightUnitCode weightUnit) {
        this.weightUnit = weightUnit;
    }

    public WeightUnitCode getWeightUnit() {
        return weightUnit;
    }

}