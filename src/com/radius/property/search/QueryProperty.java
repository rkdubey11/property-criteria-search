package com.radius.property.search;

import java.util.List;


//TableName: properties (id, latitude, longitude, price, bedroom, bathroom)
public class QueryProperty {

    //assuming all properties are stored in table named 'properties'
    private static final String QUERY = "select * from properties where %latitude% and %price% and %bedroom% and %bathroom%";

    public static List<Property> getPropertiesFromDB (Constraint constraint) {
        List<Property> result = null;

        String bedroom = "";
        String bathroom = "";

        double minDistance = constraint.getLatitude() - (Constraint.DISTANCE_RANGE * 1.1508/60);
        double maxDistance = constraint.getLatitude() + (Constraint.DISTANCE_RANGE * 1.1508/60);

        String latitude = " latitude between " + minDistance + " and " + maxDistance;

        String price = "price between " + constraint.getMinPrice()*.75 + " and " + constraint.getMaxPrice()*1.25;

        if (constraint.getMinBedroom() != null && constraint.getMaxBedroom() != null) {
            bedroom += " bedroom > " + (constraint.getMinBedroom()-2) + " and " + " bedroom < " + constraint.getMaxBedroom()+2;
        } else if (constraint.getMinBedroom() != null) {
            bedroom += " bedroom > " + (constraint.getMinBedroom()-2);
        } else if (constraint.getMaxBedroom() != null) {
            bedroom += " bedroom < " + (constraint.getMaxBedroom()+2);
        }

        if (constraint.getMinBedroom() != null && constraint.getMaxBedroom() != null) {
            bathroom += " bathroom > " + (constraint.getMinBathroom()-2) + " and " + " bathroom < " + (constraint.getMaxBathroom()+2);
        } else if (constraint.getMinBedroom() != null) {
            bathroom += " bathroom > " + (constraint.getMinBathroom()-2);
        } else if (constraint.getMaxBedroom() != null) {
            bathroom += " bathroom < " + (constraint.getMaxBathroom()+2);
        }

        String query = QueryProperty.QUERY
                .replace("%latitude%", latitude)
                .replace("%price%", price)
                .replace("%bedroom%", bedroom)
                .replace("%bathroom%", bathroom);


        //assumption execute method will fetch the property from SQL DB for the given query
        result = execute(query);

        return result;
    }


}
