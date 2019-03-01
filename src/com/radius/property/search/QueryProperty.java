package com.radius.property.search;

import java.util.List;


//TableName: properties (id, latitude, longitude, price, bedroom, bathroom)
public class QueryProperty {

    private static final String QUERY = "select * from properties where %latitude% and %price% and %bedroom% and %bathroom%" ;

    public static List<Property> getPropertiesFromDB (Constraint constraint) {
        List<Property> result = null;

        String bedroom = "";
        String bathroom = "";

        double min = constraint.getLatitude() - (Constraint.DISTANCE_RANGE * 1.1508/60);
        double max = constraint.getLatitude() + (Constraint.DISTANCE_RANGE * 1.1508/60);

        String latitude = " latitude between " + min + " and " + max;

        String price = "price between " + constraint.getMinPrice() + " and " + constraint.getMaxBathroom();

        if (constraint.getMinBedroom() != null && constraint.getMaxBedroom() != null) {
            bedroom += " bedroom > " + constraint.getMinBedroom() + " and " + " bedroom < " + constraint.getMaxBedroom();
        } else if (constraint.getMinBedroom() != null) {
            bedroom += " bedroom > " + constraint.getMinBedroom();
        } else if (constraint.getMaxBedroom() != null) {
            bedroom += " bedroom < " + constraint.getMaxBedroom();
        }

        if (constraint.getMinBedroom() != null && constraint.getMaxBedroom() != null) {
            bathroom += " bathroom > " + constraint.getMinBathroom() + " and " + " bathroom < " + constraint.getMaxBathroom();
        } else if (constraint.getMinBedroom() != null) {
            bathroom += " bathroom > " + constraint.getMinBathroom();
        } else if (constraint.getMaxBedroom() != null) {
            bathroom += " bathroom < " + constraint.getMaxBathroom();
        }

        String query = QueryProperty.QUERY
                .replace("%latitude%", latitude)
                .replace("%price%", price)
                .replace("%bedroom%", bedroom)
                .replace("%bathroom%", bathroom);

        /*

        result = execute(query);

        */

        return result;
    }


}
