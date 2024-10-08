
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.util.Set;


/**
 * Action to describe onloading or offloading TransportMeans
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Loading )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Loading
    extends LogisticsAction
{

    /**
     * References to Materials onloaded or offloaded
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_loadedMaterials)
    protected Set<LoadingMaterial> loadedMaterials;
    /**
     * References to Pieces onloaded or offloaded
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_loadedPieces)
    @Exclude
    protected Set<Piece> loadedPieces;
    /**
     * References to LoadingUnits onloaded or offloaded
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_loadedUnits)
    protected Set<LoadingUnit> loadedUnits;
    /**
     * Enum stating whether the LoadingAction describes onloading or offloading
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_loadingType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected LoadingType loadingType;
    /**
     * Reference to the TransportMeans that is being onloaded or offloaded
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_onTransportMeans)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected TransportMeans onTransportMeans;
    /**
     * Short text stating the loading position in the TransportMeans
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_loadingPositionIdentifier)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String loadingPositionIdentifier;

    public void setLoadedMaterials(Set<LoadingMaterial> loadedMaterials) {
        this.loadedMaterials = loadedMaterials;
    }

    public Set<LoadingMaterial> getLoadedMaterials() {
        return loadedMaterials;
    }

    public void setLoadedPieces(Set<Piece> loadedPieces) {
        this.loadedPieces = loadedPieces;
    }

    public Set<Piece> getLoadedPieces() {
        return loadedPieces;
    }

    public void setLoadedUnits(Set<LoadingUnit> loadedUnits) {
        this.loadedUnits = loadedUnits;
    }

    public Set<LoadingUnit> getLoadedUnits() {
        return loadedUnits;
    }

    public void setLoadingType(LoadingType loadingType) {
        this.loadingType = loadingType;
    }

    public LoadingType getLoadingType() {
        return loadingType;
    }

    public void setOnTransportMeans(TransportMeans onTransportMeans) {
        this.onTransportMeans = onTransportMeans;
    }

    public TransportMeans getOnTransportMeans() {
        return onTransportMeans;
    }

    public void setLoadingPositionIdentifier(String loadingPositionIdentifier) {
        this.loadingPositionIdentifier = loadingPositionIdentifier;
    }

    public String getLoadingPositionIdentifier() {
        return loadingPositionIdentifier;
    }

}
