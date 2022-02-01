package com.application.potometeo;

import java.io.Serializable;

public class City implements Serializable {

    private String id;
    private String name;
    private String country;

    public City(String id, String name, String country)  {
        this.id = id;
        this.name = name;
        this.country = country;
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

    @Override
    public String toString() {
        return this.id + this.name +" ("+ this.country+")";
    }
}

