package com.softlica.bishal.myapplication.Model.Repository;

import com.softlica.bishal.myapplication.Model.Photos;
import com.softlica.bishal.myapplication.Model.FlickrResponseModel;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RetrieveApi {
    /*
     * Retrofit get annotation with our URL*/
    @GET("services/rest")
    Call<List<Photos>> getServerData(
    @QueryMap Map<String, String> options
    );


    @GET("services/rest")
    Call<FlickrResponseModel> getFlickerObject(
    @QueryMap Map<String, String> options
    );



    @GET("services/rest")
    Observable<FlickrResponseModel> getFlickrResponse(
    @QueryMap Map<String, String> options
    );
}
