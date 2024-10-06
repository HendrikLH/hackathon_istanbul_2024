
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.io.Serializable;


/**
 * Restricted code list for the execution status of activities
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_ExecutionStatus )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ExecutionStatus
    extends CodeListElement
    implements Serializable
{


}
