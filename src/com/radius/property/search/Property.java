package com.radius.property.search;

public class Property {

    private Long id;
    private Double latitude;
    private Double longitude;
    private Double price;
    private Long numberOfBedroom;
    private Long numberOfBathroom;
    private int score = 0;

    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int setScore(int score) {
        this.score = score;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getNumberOfBedroom() {
        return numberOfBedroom;
    }

    public void setNumberOfBedroom(Long numberOfBedroom) {
        this.numberOfBedroom = numberOfBedroom;
    }

    public Long getNumberOfBathroom() {
        return numberOfBathroom;
    }

    public void setNumberOfBathroom(Long numberOfBathroom) {
        this.numberOfBathroom = numberOfBathroom;
    }

    public double getDistance(Constraint constraint){
        double distance=0; //Use ‘Haversine’ formula to calculate distance
        return distance;
    }
}
