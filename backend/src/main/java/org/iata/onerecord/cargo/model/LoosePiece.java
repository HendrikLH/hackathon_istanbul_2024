
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.io.Serializable;


/**
 * LoosePiece details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_LoosePiece )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class LoosePiece
    extends PieceGroup
    implements Serializable
{

    /**
     * Height of a single piece
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_pieceHeight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value pieceHeight;
    /**
     * Length of a single piece
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_pieceLength)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value pieceLength;
    /**
     * Weight of a single piece
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_pieceWeight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value pieceWeight;
    /**
     * Width of a single piece
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_pieceWidth)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value pieceWidth;
    /**
     * Stackable indicator for the pieces (boolean)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_stackable)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean stackable;
    /**
     * Turnable indicator for the pieces (boolean)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_turnable)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean turnable;

    public void setPieceHeight(Value pieceHeight) {
        this.pieceHeight = pieceHeight;
    }

    public Value getPieceHeight() {
        return pieceHeight;
    }

    public void setPieceLength(Value pieceLength) {
        this.pieceLength = pieceLength;
    }

    public Value getPieceLength() {
        return pieceLength;
    }

    public void setPieceWeight(Value pieceWeight) {
        this.pieceWeight = pieceWeight;
    }

    public Value getPieceWeight() {
        return pieceWeight;
    }

    public void setPieceWidth(Value pieceWidth) {
        this.pieceWidth = pieceWidth;
    }

    public Value getPieceWidth() {
        return pieceWidth;
    }

    public void setStackable(Boolean stackable) {
        this.stackable = stackable;
    }

    public Boolean getStackable() {
        return stackable;
    }

    public void setTurnable(Boolean turnable) {
        this.turnable = turnable;
    }

    public Boolean getTurnable() {
        return turnable;
    }

}
