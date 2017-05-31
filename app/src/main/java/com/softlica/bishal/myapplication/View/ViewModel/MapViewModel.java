package com.softlica.bishal.myapplication.View.ViewModel;

import com.softlica.bishal.myapplication.Model.PhotoItem;
import com.softlica.bishal.myapplication.Model.Photos;

import java.util.List;

/**
 * Created by bishal on 2/10/2017.
 */

public interface MapViewModel extends BaseViewModel {
    public void showFlickData(List<PhotoItem> data);
}
