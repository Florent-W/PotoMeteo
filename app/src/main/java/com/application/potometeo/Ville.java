package com.application.potometeo;

import java.io.Serializable;

public class Ville implements Serializable {

    private int id;
    private String name;
    private String country;

    private boolean active;

    public Ville(int id, String name, String country)  {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return this.id + this.name +" ("+ this.country+")";
    }
}

