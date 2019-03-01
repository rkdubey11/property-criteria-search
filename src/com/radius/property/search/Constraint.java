package com.radius.property.search;

public class Constraint {

    public static final Double MAX_LATITUDE = 90.0;
    public static final Double MAX_LONGITUDE = 180.0;
    public static final Double MIN_LATITUDE = -90.0;
    public static final Double MIN_LONGITUDE = -180.0;
    public static final Integer DISTANCE_RANGE = 10;



    private Double latitude;
    private Double longitude;

    private Double minPrice;
    private Double maxPrice;

    private Long minBedroom;
    private Long maxBedroom;


    private Long minBathroom;
    private Long maxBathroom;


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Long getMinBedroom() {
        return minBedroom;
    }

    public void setMinBedroom(Long minBedroom) {
        this.minBedroom = minBedroom;
    }

    public Long getMaxBedroom() {
        return maxBedroom;
    }

    public void setMaxBedroom(Long maxBedroom) {
        this.maxBedroom = maxBedroom;
    }

    public Long getMinBathroom() {
        return minBathroom;
    }

    public void setMinBathroom(Long minBathroom) {
        this.minBathroom = minBathroom;
    }

    public Long getMaxBathroom() {
        return maxBathroom;
    }

    public void setMaxBathroom(Long maxBathroom) {
        this.maxBathroom = maxBathroom;
    }

    public Boolean isValid() {
        if (longitude == null || latitude == null) {
            return false;
        }
        boolean validLongitude = longitude <= MAX_LONGITUDE && longitude >= MIN_LONGITUDE;
        boolean validLatitude = latitude <= MAX_LATITUDE && latitude >= MIN_LATITUDE;

        boolean validPrice = minPrice != null && maxPrice != null;
        boolean validBed = minBedroom != null && maxBedroom != null;
        boolean validBath = minBathroom != null && maxBathroom != null;

        return validLatitude && validLongitude && validBath && validBed && validPrice;
    }

    public void sanitize () {

        if (minPrice == null) minPrice = maxPrice*0.9;
        if (maxPrice == null) maxPrice = minPrice*1.1;
    }
}
