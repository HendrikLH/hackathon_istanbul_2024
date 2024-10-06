package org.iata.onerecord.cargo;

import lombok.Getter;

@Getter
public class ClassLookupTableRow {

    private String subject;
    private String predicate;
    private String object;

    public ClassLookupTableRow() {}

    public ClassLookupTableRow (String objectSubject, String objectPredicate, String objectObject) {
        this.subject = objectSubject;
        this.predicate = objectPredicate;
        this.object = objectObject;
    }

    @Override
    public String toString() {
        return "Row Key: "+ subject + "-" + predicate + ", Subject: " + subject + ", Predicate: " + predicate + ", Object: " + object;
    }

}
