
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;


/**
 * Details of the radioactive isotope contained in the product
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_DgRadioactiveIsotope )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DgRadioactiveIsotope
    extends LogisticsObject
{

    /**
     * Reference to the DgProductRadioactive this Isotope is contained in
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contentOfDgProductRadioactive)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected DgProductRadioactive contentOfDgProductRadioactive;
    /**
     * A description of the physical and chemical form of the material.
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_physicalChemicalForm)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected RadioactiveMaterialClassification physicalChemicalForm;
    /**
     * Numeric expression of the activity of a radioactive Item
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_activityLevelMeasure)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String activityLevelMeasure;
    /**
     * Applies to fissile material only, other than fissile excepted. A numeric value expressed to one decimal place preceded by the letters CSI.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_criticalitySafetyIndexNumeric)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String criticalitySafetyIndexNumeric;
    /**
     * Id of each radionuclide or for mixtures of radionuclides.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_isotopeId)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String isotopeId;
    /**
     * The name or symbol of each radionuclide or for mixtures of radionuclides, an appropriate general description, or a list of the most restrictive radionuclides. 
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_isotopeName)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String isotopeName;
    /**
     * A notation that the material is low dispersible radioactive material.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_lowDispersibleIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean lowDispersibleIndicator;
    /**
     * A notation that the material is special form
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_specialFormIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean specialFormIndicator;

    public void setContentOfDgProductRadioactive(DgProductRadioactive contentOfDgProductRadioactive) {
        this.contentOfDgProductRadioactive = contentOfDgProductRadioactive;
    }

    public DgProductRadioactive getContentOfDgProductRadioactive() {
        return contentOfDgProductRadioactive;
    }

    public void setPhysicalChemicalForm(RadioactiveMaterialClassification physicalChemicalForm) {
        this.physicalChemicalForm = physicalChemicalForm;
    }

    public RadioactiveMaterialClassification getPhysicalChemicalForm() {
        return physicalChemicalForm;
    }

    public void setActivityLevelMeasure(String activityLevelMeasure) {
        this.activityLevelMeasure = activityLevelMeasure;
    }

    public String getActivityLevelMeasure() {
        return activityLevelMeasure;
    }

    public void setCriticalitySafetyIndexNumeric(String criticalitySafetyIndexNumeric) {
        this.criticalitySafetyIndexNumeric = criticalitySafetyIndexNumeric;
    }

    public String getCriticalitySafetyIndexNumeric() {
        return criticalitySafetyIndexNumeric;
    }

    public void setIsotopeId(String isotopeId) {
        this.isotopeId = isotopeId;
    }

    public String getIsotopeId() {
        return isotopeId;
    }

    public void setIsotopeName(String isotopeName) {
        this.isotopeName = isotopeName;
    }

    public String getIsotopeName() {
        return isotopeName;
    }

    public void setLowDispersibleIndicator(Boolean lowDispersibleIndicator) {
        this.lowDispersibleIndicator = lowDispersibleIndicator;
    }

    public Boolean getLowDispersibleIndicator() {
        return lowDispersibleIndicator;
    }

    public void setSpecialFormIndicator(Boolean specialFormIndicator) {
        this.specialFormIndicator = specialFormIndicator;
    }

    public Boolean getSpecialFormIndicator() {
        return specialFormIndicator;
    }

}
