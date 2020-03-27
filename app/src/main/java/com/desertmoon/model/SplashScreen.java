package com.desertmoon.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SplashScreen implements Serializable {

    @SerializedName("backgroundColor")
    private String backgroundColor;

    @SerializedName("statusColor")
    private String statusColor;

    @SerializedName("imageURL")
    private String imageURL;

    @SerializedName("isShow")
    private boolean isShow;

   private int scaleType;

    public int getScaleType() {
        return scaleType;
    }

    public void setScaleType(int scaleType) {
        this.scaleType = scaleType;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
