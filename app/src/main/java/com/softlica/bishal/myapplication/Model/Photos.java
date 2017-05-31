package com.softlica.bishal.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bishal on 2/10/2017.
 */

public class Photos {
    @Expose
    @SerializedName("total")
    private int total;
    @Expose
    @SerializedName("photo")
    private List<PhotoItem> photos_list;


    public Photos(List<PhotoItem> photos) {
        this.photos_list = photos;
    }


    @Override
    public String toString() {
        return "Photos{" +
                "total=" + total +
                ", photos=" + photos_list +
                '}';
    }

    public List<PhotoItem> getPhotos() {
        return photos_list;
    }

    public void setPhotos(List<PhotoItem> photos) {
        this.photos_list = photos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}