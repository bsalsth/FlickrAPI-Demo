package com.softlica.bishal.myapplication.Utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;
import com.softlica.bishal.myapplication.Model.PhotoItem;
import com.softlica.bishal.myapplication.main.App;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bishal on 2/10/2017.
 */

public class Utility {
    public static String createImageUrl(PhotoItem item) {
//        http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
        StringBuilder url = new StringBuilder("http://farm");
        url.append(item.getFarmId());
        url.append(".staticflickr.com/");
        url.append(item.getServerId());
        url.append("/");
        url.append(item.getPhotoId());
        url.append("_");
        url.append(item.getSecretId());
        url.append(".jpg");

        return url.toString();
    }



//    Check network connection
    public static  boolean isNetworkAvailable() {
        ConnectivityManager connectivityMgr = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityMgr.getActiveNetworkInfo();
        /// if no network is available networkInfo will be null
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }


    // parameter for flick api
    public static Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("method", "flickr.photos.search");
        params.put("extras", "original_format,description,geo,date_upload,owner_name");
        params.put("has_geo", "1");
        params.put("license", "1,2,4,7");
        params.put("nojsoncallback", "Marcus");
        params.put("format", "json");
        params.put("per_page", "10");
        params.put("api_key", "7ce1d0a84c9bf0807d67d65e3974cc2b");

        return params;
    }

    public static LatLng getLatLng(String lat, String lng){
        return new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));
    }
}