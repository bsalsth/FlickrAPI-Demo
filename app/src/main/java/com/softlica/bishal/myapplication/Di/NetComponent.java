package com.softlica.bishal.myapplication.Di;


import com.softlica.bishal.myapplication.Service.FlickrService;
import com.softlica.bishal.myapplication.View.ui.CalculatorActivity;
import com.softlica.bishal.myapplication.View.ui.MapsActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    //    can be made more readable by creating seperate component
    void inject(FlickrService service);

}
