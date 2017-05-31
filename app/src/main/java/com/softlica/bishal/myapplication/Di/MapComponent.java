package com.softlica.bishal.myapplication.Di;


import com.softlica.bishal.myapplication.Service.FlickrService;
import com.softlica.bishal.myapplication.View.ui.MapsActivity;

import javax.inject.Singleton;

import dagger.Component;


@CustomScope
@Component(modules = {MapModule.class})
public interface MapComponent {

    void inject(MapsActivity activity);

}
