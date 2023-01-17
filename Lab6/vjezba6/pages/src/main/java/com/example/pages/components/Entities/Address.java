package com.example.pages.components.Entities;

public class Address {

    private String city;

    private String county;

    private String street_number;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public Address(String city, String county, String street_number) {
        this.city = city;
        this.county = county;
        this.street_number = street_number;
    }

    public Address() {
    }
}
