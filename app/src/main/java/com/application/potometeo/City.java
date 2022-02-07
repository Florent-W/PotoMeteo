package com.application.potometeo;

import java.io.Serializable;

public class City implements Serializable {

    private String id;
    private String name;
    private String country;
    private String lat;
    private String lon;

    public City(String id, String name, String country, String lat, String lon) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.country + ")";
    }
}

