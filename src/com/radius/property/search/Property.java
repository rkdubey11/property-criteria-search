package com.radius.property.search;

public class Property {

    private Double latitude;
    private Double longitude;

    private Double price;
    private Long numberOfBedroom;
    private Long numberOfBathroom;


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
}
