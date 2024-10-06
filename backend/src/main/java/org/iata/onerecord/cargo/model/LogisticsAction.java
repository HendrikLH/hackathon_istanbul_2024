
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.time.OffsetDateTime;
import java.util.Set;


/**
 * Superclass: LogisticsAction is a specific task with a specific result performed on one or more physical LOs by one party in the context of an Activity
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_LogisticsAction )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class LogisticsAction
    extends LogisticsObject
{

    /**
     * Enum stating the type of the Action
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_actionTimeType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected ActionTimeType actionTimeType;
    /**
     * Information about contactDetails
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contactDetails)
    protected Set<ContactDetail> contactDetails;
    /**
     * References to Actors (Person, NonHumanActor) acting as contacts
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contactPersons)
    protected Set<Actor> contactPersons;
    /**
     * Details about any other identifier, depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherIdentifiers)
    protected Set<OtherIdentifier> otherIdentifiers;
    /**
     * Reference to the Location the Action was performed at
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_performedAt)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location performedAt;
    /**
     * Reference to the Activity the Action was performed for
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_servedActivity)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected LogisticsActivity servedActivity;
    /**
     * DateTime holding the end time of the Action; Type is indicated through ActionType property
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_actionEndTime)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime actionEndTime;
    /**
     * DateTime holding the start time of the Action; Type is indicated through ActionType property
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_actionStartTime)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime actionStartTime;

    public void setActionTimeType(ActionTimeType actionTimeType) {
        this.actionTimeType = actionTimeType;
    }

    public ActionTimeType getActionTimeType() {
        return actionTimeType;
    }

    public void setContactDetails(Set<ContactDetail> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Set<ContactDetail> getContactDetails() {
        return contactDetails;
    }

    public void setContactPersons(Set<Actor> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public Set<Actor> getContactPersons() {
        return contactPersons;
    }

    public void setOtherIdentifiers(Set<OtherIdentifier> otherIdentifiers) {
        this.otherIdentifiers = otherIdentifiers;
    }

    public Set<OtherIdentifier> getOtherIdentifiers() {
        return otherIdentifiers;
    }

    public void setPerformedAt(Location performedAt) {
        this.performedAt = performedAt;
    }

    public Location getPerformedAt() {
        return performedAt;
    }

    public void setServedActivity(LogisticsActivity servedActivity) {
        this.servedActivity = servedActivity;
    }

    public LogisticsActivity getServedActivity() {
        return servedActivity;
    }

    public void setActionEndTime(OffsetDateTime actionEndTime) {
        this.actionEndTime = actionEndTime;
    }

    public OffsetDateTime getActionEndTime() {
        return actionEndTime;
    }

    public void setActionStartTime(OffsetDateTime actionStartTime) {
        this.actionStartTime = actionStartTime;
    }

    public OffsetDateTime getActionStartTime() {
        return actionStartTime;
    }

}
