
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.io.Serializable;


/**
 * Non-human actors are actors which are not a person, such as robots
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_NonHumanActor )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class NonHumanActor
    extends Actor
    implements Serializable
{


}
