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

    public void transformConstraintforScoring(Constraint constraint){
        if (constraint.getMinPrice()== null){
            constraint.setMinPrice(constraint.getMaxPrice()*0.9);
            constraint.setMaxPrice(constraint.getMaxPrice()*1.1);
        }
        if (constraint.getMaxPrice()== null){
            constraint.setMaxPrice(constraint.getMinPrice()*1.1);
            constraint.setMinPrice(constraint.getMaxPrice()*0.9);
        }
    }

    private int getScore (Property property, Constraint constraint) {
        int score=0;

        if(property.getDistance(constraint)<=2){
            score+=30;
        }

        if(constraint.getMinPrice()<= property.getPrice() && property.getPrice()<= constraint.getMaxPrice()){
            score+=30;
        }

        if(constraint.getMinBedroom()!=null && constraint.getMaxBedroom()!=null && constraint.getMinBedroom() <= property.getNumberOfBedroom() && property.getNumberOfBedroom() <= constraint.getMaxBedroom()){
            score+=20;
        }

        if(constraint.getMinBathroom() != null && constraint.getMaxBathroom()!=null && constraint.getMinBathroom() <= property.getNumberOfBathroom() && property.getNumberOfBathroom() <= constraint.getMaxBathroom()){
            score+=20;
        }

        // cases when min or max bedroom/bathroom are not available in search criterion
        if(constraint.getMinBedroom()==null){
            if(property.getNumberOfBedroom() <= constraint.getMaxBedroom()){
                score+=20;
            }
        }

        if(constraint.getMaxBedroom()==null){
            if(property.getNumberOfBedroom() >= constraint.getMinBedroom()){
                score+=20;
            }
        }

        if(constraint.getMinBathroom() == null){
            if(property.getNumberOfBathroom() <=  constraint.getMaxBathroom()){
                score+=20;
            }
        }

        if(constraint.getMaxBathroom() == null){
            if(property.getNumberOfBathroom() >= constraint.getMinBathroom()){
                score+=20;
            }
        }

        property.setScore(score);
        return score;
    }
}
