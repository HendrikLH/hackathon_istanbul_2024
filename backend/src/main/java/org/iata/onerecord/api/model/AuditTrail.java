
package org.iata.onerecord.api.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import cz.cvut.kbss.jopa.vocabulary.RDFS;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.api.Vocabulary;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


/**
 * Audit trail of a Logistics Object
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_AuditTrail )
@SuperBuilder
@EqualsAndHashCode
public class AuditTrail
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
     * Recorded change requests in the Audit Trail of a Logistics Object
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_hasChangeRequest)
    protected Set<ChangeRequest> hasChangeRequest;
    /**
     * Latest revision of the Logistics Object. Starting with revision 0
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasLatestRevision)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#positiveInteger", min = 1, max = 1)
    })
    protected Integer hasLatestRevision;

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
        return ((((("AuditTrail {"+ name)+"<")+ id)+">")+"}");
    }

    public void setHasChangeRequest(Set<ChangeRequest> hasChangeRequest) {
        this.hasChangeRequest = hasChangeRequest;
    }

    public Set<ChangeRequest> getHasChangeRequest() {
        return hasChangeRequest;
    }

    public void setHasLatestRevision(Integer hasLatestRevision) {
        this.hasLatestRevision = hasLatestRevision;
    }

    public Integer getHasLatestRevision() {
        return hasLatestRevision;
    }

}
