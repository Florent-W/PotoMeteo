package com.application.potometeo;

public class Display {

    private String nameImg;

    // Image name (Without extension)
    private String linkImg;
    private String available;

    public Display(String nameImg, String linkImg, String available) {
        this.nameImg = nameImg;
        this.linkImg = linkImg;
        this.available = available;
    }

    public String getClothes() {
        return available;
    }

    public String getNameImg() {
        return nameImg;
    }

    public String getLinkImg() {
        return linkImg;
    }

    @Override
    public String toString() {
        return String.format("%s[%s] - %s", this.nameImg, this.linkImg, this.available);
    }
}