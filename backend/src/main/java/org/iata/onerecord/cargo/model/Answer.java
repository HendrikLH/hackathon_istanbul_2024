
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.util.Set;


/**
 * Answer holds the answer to one Question and is provided by the executioner of the check
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Answer )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Answer
    extends LogisticsObject
{

    /**
     * Reference to the Actor giving the Answer
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_answerActor)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Actor answerActor;
    /**
     * Information about an answer Value of any kind of the Answer
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_answerValue)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value answerValue;
    /**
     * Reference to the Location from which the Question was answered, relevant for split checks with documentary and physical elements
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_givenAtLocation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location givenAtLocation;
    /**
     * Information about other Parties involved depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_involvedParties)
    protected Set<Party> involvedParties;
    /**
     * Reference to the Question the Answer is for
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_question)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Question question;
    /**
     * Text for the Answer
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_text)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String text;

    public void setAnswerActor(Actor answerActor) {
        this.answerActor = answerActor;
    }

    public Actor getAnswerActor() {
        return answerActor;
    }

    public void setAnswerValue(Value answerValue) {
        this.answerValue = answerValue;
    }

    public Value getAnswerValue() {
        return answerValue;
    }

    public void setGivenAtLocation(Location givenAtLocation) {
        this.givenAtLocation = givenAtLocation;
    }

    public Location getGivenAtLocation() {
        return givenAtLocation;
    }

    public void setInvolvedParties(Set<Party> involvedParties) {
        this.involvedParties = involvedParties;
    }

    public Set<Party> getInvolvedParties() {
        return involvedParties;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
