package com.softlica.bishal.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bishal on 2/10/2017.
 */

public class PhotoItem {
    //    Image url
//    http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
    @SerializedName("title")
    private String title;
    @SerializedName("ownername")
    private String ownername;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    // FOR PHOTO URL
    @SerializedName("farm")
    private String farmId;
    @SerializedName("server")
    private String serverId;
    @SerializedName("secret")
    private String secretId;
    @SerializedName("id")
    private String photoId;

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "title='" + title + '\'' +
                ", ownername='" + ownername + '\'' +
                ", latitude=" + latitude +
                ", Longitude=" + longitude +
                '}';
    }

    public PhotoItem(String title, String ownername, String latitude, String Longitude) {
        this.title = title;
        this.ownername = ownername;
        this.latitude = latitude;
        this.longitude = Longitude;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getownername() {
        return ownername;
    }

    public void setownername(String ownername) {
        this.ownername = ownername;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String Longitude) {
        this.longitude = Longitude;
    }
}