package com.softlica.bishal.myapplication.Service;

import android.provider.SyncStateContract;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.softlica.bishal.myapplication.Model.FlickrResponseModel;
import com.softlica.bishal.myapplication.Model.PhotoItem;
import com.softlica.bishal.myapplication.Model.Repository.RetrieveApi;
import com.softlica.bishal.myapplication.Utility.Constant;
import com.softlica.bishal.myapplication.Utility.Utility;
import com.softlica.bishal.myapplication.main.App;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bishal on 5/30/2017.
 */

public class FlickrService {

    CompositeDisposable compositeDisposable;

   @Inject
    Retrofit retrofit;

    public FlickrService(){
        compositeDisposable = new CompositeDisposable();
        App.getNetComponent().inject(this);
    }

    public CompositeDisposable callFlickr(final OnDownloadListener listener){

        RetrieveApi apiService = retrofit.create(RetrieveApi.class);
        compositeDisposable.add(apiService.getFlickrResponse(Utility.getParams()).
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FlickrResponseModel>() {
                    @Override
                    public void onNext(FlickrResponseModel value) {
                        List<PhotoItem> photo_list = value.getModel().getPhotos();
                        for (PhotoItem item : photo_list)
                            Log.e("Photos", item.getownername());
                        listener.onSucces(photo_list);

                    }
                    @Override
                    public void onError(Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onComplete() {
                    }
                })
        );
        return  compositeDisposable;
    }

    // Call back for data loading
    public interface OnDownloadListener {
        public void onSucces( List<PhotoItem> photos);
        public void onError();
    }
}
