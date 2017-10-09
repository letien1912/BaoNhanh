package com.model;

/**
 * Created by Le on 15-Jan-16.
 */
public class LogoWebsiteItem {
    private String nameWebsite;
    private int imageID;

    public LogoWebsiteItem(String nameWebsite, int imageID) {
        this.nameWebsite = nameWebsite;
        this.imageID = imageID;
    }

    public void setNameWebsite(String nameWebsite) {
        this.nameWebsite = nameWebsite;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getNameWebsite() {
        return nameWebsite;
    }

    public int getImageID() {
        return imageID;
    }

    @Override
    public String toString() {
        return "LogoWebsiteItem{" +
                "nameWebsite='" + nameWebsite + '\'' +
                ", imageID=" + imageID +
                '}';
    }
}
