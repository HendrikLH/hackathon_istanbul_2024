
package org.iata.onerecord.api.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import cz.cvut.kbss.jopa.vocabulary.RDFS;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.api.Vocabulary;
import org.iata.onerecord.cargo.model.Organization;

import java.io.Serializable;
import java.net.URI;
import java.util.Map;
import java.util.Set;


/**
 * Information about the ONE Record server in the Internet of Logistics
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_ServerInformation )
@SuperBuilder
@EqualsAndHashCode
public class ServerInformation
    implements Serializable
{

    @Id(generated = true)
    protected String id;
    @OWLAnnotationProperty(iri = RDFS.LABEL)
    protected String name;
    @OWLAnnotationProperty(iri = cz.cvut.kbss.jopa.vocabulary.DC.Elements.DESCRIPTION)
    protected String description;
    @Types
    protected Set<String> types;
    @Properties
    protected Map<String, Set<String>> properties;
    /**
     * The data holder of the servers data.
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_hasDataHolder)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Organization, min = 1, max = 1)
    })
    protected Organization hasDataHolder;
    /**
     * ONE Record API endpoint in the Internet of Logistics
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasServerEndpoint)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral", min = 1, max = 1)
    })
    protected Set<String> hasServerEndpoint;
    /**
     * Supported ONE Record API versions by the server, MUST include at least one supported version.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasSupportedApiVersion)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral", min = 1, max = -1)
    })
    protected Set<String> hasSupportedApiVersion;
    /**
     * Supported content types of the server, MUST contain at least application/ld+json
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasSupportedContentType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral", min = 1, max = -1)
    })
    protected Set<String> hasSupportedContentType;
    /**
     * Optional list of supported encodings of the ONE Record server, e.g. gzip
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasSupportedEncoding)
    protected Set<String> hasSupportedEncoding;
    /**
     * Supported languages of the ONE Record API, minimum is en-US (American English)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasSupportedLanguage)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", min = 1, max = -1)
    })
    protected Set<String> hasSupportedLanguage;
    /**
     * Supported ontologies on the server, MUST be non-versioned IRIs
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasSupportedOntology)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#anyURI", min = 1, max = -1)
    })
    protected Set<URI> hasSupportedOntology;
    /**
     * Supported ontology versions on the server, MUST be versioned IRIs
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_hasSupportedOntologyVersion)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral", min = 1, max = -1)
    })
    protected Set<String> hasSupportedOntologyVersion;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setProperties(Map<String, Set<String>> properties) {
        this.properties = properties;
    }

    public Map<String, Set<String>> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return ((((("ServerInformation {"+ name)+"<")+ id)+">")+"}");
    }

    public void setHasDataHolder(Organization hasDataHolder) {
        this.hasDataHolder = hasDataHolder;
    }

    public Organization getHasDataHolder() {
        return hasDataHolder;
    }

    public void setHasServerEndpoint(Set<String> hasServerEndpoint) {
        this.hasServerEndpoint = hasServerEndpoint;
    }

    public Set<String> getHasServerEndpoint() {
        return hasServerEndpoint;
    }

    public void setHasSupportedApiVersion(Set<String> hasSupportedApiVersion) {
        this.hasSupportedApiVersion = hasSupportedApiVersion;
    }

    public Set<String> getHasSupportedApiVersion() {
        return hasSupportedApiVersion;
    }

    public void setHasSupportedContentType(Set<String> hasSupportedContentType) {
        this.hasSupportedContentType = hasSupportedContentType;
    }

    public Set<String> getHasSupportedContentType() {
        return hasSupportedContentType;
    }

    public void setHasSupportedEncoding(Set<String> hasSupportedEncoding) {
        this.hasSupportedEncoding = hasSupportedEncoding;
    }

    public Set<String> getHasSupportedEncoding() {
        return hasSupportedEncoding;
    }

    public void setHasSupportedLanguage(Set<String> hasSupportedLanguage) {
        this.hasSupportedLanguage = hasSupportedLanguage;
    }

    public Set<String> getHasSupportedLanguage() {
        return hasSupportedLanguage;
    }

    public void setHasSupportedOntology(Set<URI> hasSupportedOntology) {
        this.hasSupportedOntology = hasSupportedOntology;
    }

    public Set<URI> getHasSupportedOntology() {
        return hasSupportedOntology;
    }

    public void setHasSupportedOntologyVersion(Set<String> hasSupportedOntologyVersion) {
        this.hasSupportedOntologyVersion = hasSupportedOntologyVersion;
    }

    public Set<String> getHasSupportedOntologyVersion() {
        return hasSupportedOntologyVersion;
    }

}