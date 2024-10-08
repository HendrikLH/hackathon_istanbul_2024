
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.io.Serializable;


/**
 * Open code list for types of contact details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri =Vocabulary.s_c_ContactDetailType )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ContactDetailType
    extends CodeListElement
    implements Serializable
{


}
