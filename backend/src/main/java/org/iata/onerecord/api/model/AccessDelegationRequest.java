
package org.iata.onerecord.api.model;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.api.Vocabulary;

import java.io.Serializable;


/**
 * Delegation Request to 3rd parties
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_AccessDelegationRequest )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AccessDelegationRequest
    extends ActionRequest
    implements Serializable
{

    @OWLObjectProperty(iri = Vocabulary.s_p_hasAccessDelegation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_AccessDelegation, min = 1, max = 1)
    })
    protected AccessDelegation hasAccessDelegation;

    public void setHasAccessDelegation(AccessDelegation hasAccessDelegation) {
        this.hasAccessDelegation = hasAccessDelegation;
    }

    public AccessDelegation getHasAccessDelegation() {
        return hasAccessDelegation;
    }

}
