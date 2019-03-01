package com.radius.property.search;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Search {

    private static final Integer THRESHOLD_MATCH_SCORE = 40;

    public List<Property> getMatchingProperties (Constraint constraint) {
        if (constraint == null || !constraint.isValid()) {
            return Collections.emptyList();
        }
        constraint.sanitize();

        List<Property> properties = QueryProperty.getPropertiesFromDB(constraint);
        Iterator <Property> iterator = properties.iterator();
        while (iterator.hasNext()) {
            Property property = iterator.next();
            if (getScore(property, constraint) < THRESHOLD_MATCH_SCORE) {
                iterator.remove();
            }
        }
        return properties;

    }

    private int getScore (Property property, Constraint constraint) {


    }



}
