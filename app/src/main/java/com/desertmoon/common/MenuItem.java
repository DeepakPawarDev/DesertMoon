package com.desertmoon.common;

public class MenuItem {



    private int intImageID;
    private String strImageURL;
    private String strTitle;
    private double dblPrice;
    private String strTitleDescription;

    public double getDblPrice() {
        return dblPrice;
    }

    public void setDblPrice(double dblPrice) {
        this.dblPrice = dblPrice;
    }

    public String getStrTitleDescription() {
        return strTitleDescription;
    }

    public void setStrTitleDescription(String strTitleDescription) {
        this.strTitleDescription = strTitleDescription;
    }

    public int getIntImageID() {
        return intImageID;
    }

    public void setIntImageID(int intImageID) {
        this.intImageID = intImageID;
    }

    public String getStrImageURL() {
        return strImageURL;
    }

    public void setStrImageURL(String strImageURL) {
        this.strImageURL = strImageURL;
    }

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }
}
