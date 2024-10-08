
package org.w3c.auth.acl.model;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.w3c.auth.acl.Vocabulary;

import java.io.Serializable;


/**
 * Allows read/write access to the ACL for the resource(s)
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri =Vocabulary.s_c_Control )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Control
    extends Access
    implements Serializable
{


}
