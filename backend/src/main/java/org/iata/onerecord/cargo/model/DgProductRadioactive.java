
package org.iata.onerecord.cargo.model;

import cz.cvut.kbss.jopa.model.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.iata.onerecord.cargo.Vocabulary;

import java.util.Set;


/**
 * Details of the radioactive products 
 * 
 * This class was generated by OWL2Java 1.1.4
 * 
 */
@OWLClass(iri = Vocabulary.s_c_DgProductRadioactive )
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DgProductRadioactive
    extends LogisticsObject
{

    /**
     * The category of the package or all packed in one. Complete text to be transmitted: I-White, II-Yellow, III-Yellow instead of I, II, III
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_dgRaTypeCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected RaTypeCode dgRaTypeCode;
    /**
     * Reference to the ProductDg this DgProductRadiosctive details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_forProductDg)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected ProductDg forProductDg;
    /**
     * DgRadioactiveIsotope.
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_isotopes)
    protected Set<DgRadioactiveIsotope> isotopes;
    /**
     * Indicates if Fissile is excepted
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_fissileExceptionIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean fissileExceptionIndicator;
    /**
     * Fissile exception reference, mandatory if Fissile Exception Indicator is true.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_fissileExceptionReference)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String fissileExceptionReference;
    /**
     * Radioactive Transport-Index value of the package or all packed in one. Conditionally mandator and applies to categories II-Yellow and III-Yellow only; field only contains the value, if printed, TI must be added as a prefix to the value  to be printed in the Packing Instructions column
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_transportIndexNumeric)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer transportIndexNumeric;

    public void setDgRaTypeCode(RaTypeCode dgRaTypeCode) {
        this.dgRaTypeCode = dgRaTypeCode;
    }

    public RaTypeCode getDgRaTypeCode() {
        return dgRaTypeCode;
    }

    public void setForProductDg(ProductDg forProductDg) {
        this.forProductDg = forProductDg;
    }

    public ProductDg getForProductDg() {
        return forProductDg;
    }

    public void setIsotopes(Set<DgRadioactiveIsotope> isotopes) {
        this.isotopes = isotopes;
    }

    public Set<DgRadioactiveIsotope> getIsotopes() {
        return isotopes;
    }

    public void setFissileExceptionIndicator(Boolean fissileExceptionIndicator) {
        this.fissileExceptionIndicator = fissileExceptionIndicator;
    }

    public Boolean getFissileExceptionIndicator() {
        return fissileExceptionIndicator;
    }

    public void setFissileExceptionReference(String fissileExceptionReference) {
        this.fissileExceptionReference = fissileExceptionReference;
    }

    public String getFissileExceptionReference() {
        return fissileExceptionReference;
    }

    public void setTransportIndexNumeric(Integer transportIndexNumeric) {
        this.transportIndexNumeric = transportIndexNumeric;
    }

    public Integer getTransportIndexNumeric() {
        return transportIndexNumeric;
    }

}
