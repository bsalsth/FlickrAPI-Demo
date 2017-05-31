package com.softlica.bishal.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bishal on 2/10/2017.
 */

public class FlickrResponseModel {
    @Expose
    @SerializedName("photos")
    Photos model;
    public FlickrResponseModel(Photos model) {
        this.model = model;
    }

    public Photos getModel() {
        return model;
    }

    public void setModel(Photos model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "FlickrResponseModel{" +
                "model=" + model +
                '}';
    }


}
