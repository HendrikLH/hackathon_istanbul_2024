
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.io.Serializable;
import java.util.Set;


/**
 * Person details
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Person )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Person
    extends Actor
    implements Serializable
{

    /**
     * Information about contactDetails
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contactDetails)
    protected Set<ContactDetail> contactDetails;
    /**
     * Contact type - e.g. Emergency contact, Customs contact, Customer contact
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contactRole)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected ContactRole contactRole;
    /**
     * Linked documents to the person, e.g. driver's license, ID, etc.
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_documents)
    protected Set<ExternalReference> documents;
    /**
     * Department / Division / Unit
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_department)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String department;
    /**
     * Employee ID
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_employeeId)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String employeeId;
    /**
     * First name / given name
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_firstName)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String firstName;
    /**
     * Job title / position
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_jobTitle)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String jobTitle;
    /**
     * Last name / family name / surname
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_lastName)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String lastName;
    /**
     * Middle name/ other name
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_middleName)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String middleName;
    /**
     * Salutation 
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_salutation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String salutation;

    public void setContactDetails(Set<ContactDetail> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Set<ContactDetail> getContactDetails() {
        return contactDetails;
    }

    public void setContactRole(ContactRole contactRole) {
        this.contactRole = contactRole;
    }

    public ContactRole getContactRole() {
        return contactRole;
    }

    public void setDocuments(Set<ExternalReference> documents) {
        this.documents = documents;
    }

    public Set<ExternalReference> getDocuments() {
        return documents;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getSalutation() {
        return salutation;
    }

}
