
package org.w3c.auth.acl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.Types;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.w3c.auth.acl.Vocabulary;

import java.io.Serializable;
import java.util.Set;


/**
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri =Vocabulary.s_c_Agent )
@SuperBuilder
@EqualsAndHashCode
public class Agent
    implements Serializable
{

    @Id(generated = true)
    @JsonProperty("@id")
    protected String id;

    @Types
    @JsonProperty("@type")
    protected Set<String> types;
    
    
    
    

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    

    

    

    

    

    

    

    

    @Override
    public String toString() {
        return ((((("Agent {")+"<")+ id)+">")+"}");
    }

}
