package com.application.potometeo;

public class Display {

    private String nameImg;

    // Image name (Without extension)
    private String linkImg;
    private String newClothes;

    public Display(String nameImg, String linkImg, String newClothes) {
        this.nameImg = nameImg;
        this.linkImg = linkImg;
        this.newClothes = newClothes;
    }

    public String getClothes() {
        return newClothes;
    }

    public void setClothes(String newClothes) {
        this.newClothes = newClothes;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    @Override
    public String toString() {
        return this.nameImg + " (Tenu: " + this.newClothes + ")";
    }
}