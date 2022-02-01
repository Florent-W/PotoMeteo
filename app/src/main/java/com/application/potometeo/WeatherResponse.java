package com.application.potometeo;

public class WeatherResponse {

    private Object coord;
    private Object[] weather;
    private String base;
    private WeatherResponseMain main;
    private String visibility;
    private Object wind;
    private Object clouds;
    private String dt;
    private Object sys;
    private String timezone;
    private String id;
    private String name;
    private String cod;

    public Object getCoord() {
        return coord;
    }

    public Object[] getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public WeatherResponseMain getMain() {
        return main;
    }

    public String getVisibility() {
        return visibility;
    }

    public Object getWind() {
        return wind;
    }

    public Object getClouds() {
        return clouds;
    }

    public String getDt() {
        return dt;
    }

    public Object getSys() {
        return sys;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCod() {
        return cod;
    }
}
