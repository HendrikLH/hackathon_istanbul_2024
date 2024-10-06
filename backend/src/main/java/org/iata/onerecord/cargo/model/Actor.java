
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;


/**
 * Superclass: Actors are Persons or entities acting like a single person
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Actor )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Actor
    extends LogisticsAgent
{

    /**
     * Reference to the Organization the Actor is associated with
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_associatedOrganization)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Organization associatedOrganization;

    public void setAssociatedOrganization(Organization associatedOrganization) {
        this.associatedOrganization = associatedOrganization;
    }

    public Organization getAssociatedOrganization() {
        return associatedOrganization;
    }

}