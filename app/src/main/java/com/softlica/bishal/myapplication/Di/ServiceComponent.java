package com.softlica.bishal.myapplication.Di;


import com.softlica.bishal.myapplication.Service.FlickrService;
import com.softlica.bishal.myapplication.View.ui.CalculatorActivity;
import com.softlica.bishal.myapplication.View.ui.MapsActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ServiceModule.class})
public interface ServiceComponent {


}
