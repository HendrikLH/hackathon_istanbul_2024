
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;


/**
 * CheckTotalResult holds the result of a Check and should be provided by the party executing and accounting for the check result
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_CheckTotalResult )
@SuperBuilder
@EqualsAndHashCode(callSuper = true, exclude = {"resultOfCheck"})
@NoArgsConstructor
public class CheckTotalResult
    extends LogisticsObject
{

    /**
     * Reference to the Actor certifying the result of the Check if required
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_certifiedByActor)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Person certifiedByActor;
    @OWLObjectProperty(iri = Vocabulary.s_p_resultOfCheck)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Check resultOfCheck;
    /**
     * Information about a result Value of any kind of the Check
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_resultValue)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value resultValue;
    /**
     * Free text remarks to the check result
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_checkRemark)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String checkRemark;
    /**
     * Boolean indicating whether the Check was passed
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_passed)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean passed;

    public void setCertifiedByActor(Person certifiedByActor) {
        this.certifiedByActor = certifiedByActor;
    }

    public Person getCertifiedByActor() {
        return certifiedByActor;
    }

    public void setResultOfCheck(Check resultOfCheck) {
        this.resultOfCheck = resultOfCheck;
    }

    public Check getResultOfCheck() {
        return resultOfCheck;
    }

    public void setResultValue(Value resultValue) {
        this.resultValue = resultValue;
    }

    public Value getResultValue() {
        return resultValue;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public Boolean getPassed() {
        return passed;
    }

}
