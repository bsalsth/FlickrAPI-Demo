package com.softlica.bishal.myapplication.Presenter;

import com.google.android.gms.maps.model.MarkerOptions;
import com.softlica.bishal.myapplication.Di.DaggerServiceComponent;
import com.softlica.bishal.myapplication.Model.MarkerModel;
import com.softlica.bishal.myapplication.Model.PhotoItem;
import com.softlica.bishal.myapplication.Service.FlickrService;
import com.softlica.bishal.myapplication.Utility.Utility;
import com.softlica.bishal.myapplication.View.ViewModel.MapViewModel;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by bishal on 2/10/2017.
 */

public class MapPresenter implements BasePresenter {

    FlickrService flickrService;
    List<PhotoItem> data;
    List<MarkerModel> markerList;
    MapViewModel view;
    List<MarkerOptions> markers = Collections.EMPTY_LIST;
    CompositeDisposable disposable;

    @Inject
    public MapPresenter(MapViewModel view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        flickrService = new FlickrService();
       disposable =  flickrService.callFlickr(new FlickrService.OnDownloadListener() {
            @Override
            public void onSucces(List<PhotoItem> photos) {
                view.showFlickData(photos);
            }

            @Override
            public void onError() {

            }
        });
    }

    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        disposable.clear();
    }

}
