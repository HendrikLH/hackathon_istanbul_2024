package com.lhcargo_lhind_jettainer.hackathon_istanbul.model;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class API {

    private static API instance;

    // map of ONE Record object properties to their respective types
    private static final Map<String, String> objectPropertyTypeMap = new HashMap<>();

    // Private constructor to prevent instantiation
    private API() {
        try {
            initObjectPropertyTypeMap();
        } catch (Exception e) {
            log.error("Failed to initialize object property type map", e);
        }
    }

     // Public method to access the singleton instance
     public static API getInstance() {
        if (instance == null) {
            synchronized (API.class) {
                if (instance == null) { // Double-check locking
                    instance = new API();
                }
            }
        }
        return instance;
    }

    public Boolean hasObjectProperty(String iri) {
        return objectPropertyTypeMap.containsKey(iri);
    }

    public String getObjectPropertyType(String iri) {
        return objectPropertyTypeMap.get(iri);
    }

    private static void initObjectPropertyTypeMap() {
        final String basePackage = "org.iata.onerecord.api.model";
        Reflections reflections = new Reflections(basePackage, Scanners.TypesAnnotated, Scanners.FieldsAnnotated);

        // Map class names to their OWL IRIs
        Set<Class<?>> owlClasses = reflections.getTypesAnnotatedWith(OWLClass.class);
        Map<String, String> classNameToIriMap = new HashMap<>();
        owlClasses.forEach(clazz -> {
            OWLClass owlClass = clazz.getAnnotation(OWLClass.class);
            classNameToIriMap.put(clazz.getName(), owlClass.iri()); // Use full class name for accuracy
        });

        // Process fields annotated with @OWLObjectProperty
        Set<Field> objectProperties = reflections.getFieldsAnnotatedWith(OWLObjectProperty.class);
        objectProperties.forEach(field -> {
            OWLObjectProperty propertyAnnotation = field.getAnnotation(OWLObjectProperty.class);
            Class<?> fieldType = field.getType();
            String fieldTypeName = fieldType.getName();

            // Check if the field is a collection
            if (Collection.class.isAssignableFrom(fieldType)) {
                // Extract the actual type argument from the collection
                Type genericFieldType = field.getGenericType();
                if (genericFieldType instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) genericFieldType;
                    Type[] typeArguments = parameterizedType.getActualTypeArguments();
                    if (typeArguments.length > 0 && typeArguments[0] instanceof Class) {
                        Class<?> typeArgClass = (Class<?>) typeArguments[0];
                        fieldTypeName = typeArgClass.getName();
                    }
                }
            }

            // Map the property IRI to the class IRI if it exists in the map
            if (classNameToIriMap.containsKey(fieldTypeName)) {
                objectPropertyTypeMap.put(propertyAnnotation.iri(), classNameToIriMap.get(fieldTypeName));
            }
        });
    }

}
