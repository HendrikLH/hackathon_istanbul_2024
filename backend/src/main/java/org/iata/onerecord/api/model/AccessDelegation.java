
package org.iata.onerecord.api.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import cz.cvut.kbss.jopa.vocabulary.RDFS;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.api.Vocabulary;
import org.iata.onerecord.cargo.model.LogisticsObject;
import org.iata.onerecord.cargo.model.Organization;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


/**
 * Access to a Logistics Object delegated to an Organization
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_AccessDelegation )
@SuperBuilder
@EqualsAndHashCode
public class AccessDelegation
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
     * A reference to a cargo:LogisticsObject.
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_hasLogisticsObject)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_LogisticsObject, min = 1, max = -1)
    })
    protected Set<LogisticsObject> hasLogisticsObject;
    @OWLObjectProperty(iri = Vocabulary.s_p_hasPermission)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Permission, min = 1, max = -1)
    })
    protected Set<Permission> hasPermission;
    @OWLObjectProperty(iri = Vocabulary.s_p_isRequestedFor)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Organization, min = 1, max = -1)
    })
    protected Set<Organization> isRequestedFor;
    /**
     * Reason for the request (optional)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasDescription)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String hasDescription;
    /**
     * Flag specifying if the requestor wants to receive Notification from the publisher when the status of an action request changed, default=FALSE
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_notifyRequestStatusChange)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", min = 1, max = 1)
    })
    protected Boolean notifyRequestStatusChange;

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
        return ((((("AccessDelegation {"+ name)+"<")+ id)+">")+"}");
    }

    public void setHasLogisticsObject(Set<LogisticsObject> hasLogisticsObject) {
        this.hasLogisticsObject = hasLogisticsObject;
    }

    public Set<LogisticsObject> getHasLogisticsObject() {
        return hasLogisticsObject;
    }

    public void setHasPermission(Set<Permission> hasPermission) {
        this.hasPermission = hasPermission;
    }

    public Set<Permission> getHasPermission() {
        return hasPermission;
    }

    public void setIsRequestedFor(Set<Organization> isRequestedFor) {
        this.isRequestedFor = isRequestedFor;
    }

    public Set<Organization> getIsRequestedFor() {
        return isRequestedFor;
    }

    public void setHasDescription(String hasDescription) {
        this.hasDescription = hasDescription;
    }

    public String getHasDescription() {
        return hasDescription;
    }

    public void setNotifyRequestStatusChange(Boolean notifyRequestStatusChange) {
        this.notifyRequestStatusChange = notifyRequestStatusChange;
    }

    public Boolean getNotifyRequestStatusChange() {
        return notifyRequestStatusChange;
    }

}