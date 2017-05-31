package com.softlica.bishal.myapplication.Di;

import android.app.Application;

import com.softlica.bishal.myapplication.Service.CalculatorService;
import com.softlica.bishal.myapplication.Service.FlickrService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ServiceModule {

    public ServiceModule() {

    }

    @Provides
    @Singleton
    CalculatorService provideCalculatorService() {
        return new CalculatorService();
    }

    @Provides
    @Singleton
    FlickrService provideFlickrService() {
        return new FlickrService();
    }

}
