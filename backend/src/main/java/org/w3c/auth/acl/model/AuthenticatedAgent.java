
package org.w3c.auth.acl.model;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.w3c.auth.acl.Vocabulary;

/**
 * A class of agents who have been authenticated.
 * In other words, anyone can access this resource, but not anonymously.
 * The social expectation is that the authentication process will provide an
 * identify and a name, or pseudonym.
 * (A new ID should not be minted for every access: the intent is that the user
 * is able to continue to use the ID for continues interactions with peers,
 * and for example to develop a reputation)
 * 
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri =Vocabulary.s_c_AuthenticatedAgent )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AuthenticatedAgent
    extends Agent
{


}
