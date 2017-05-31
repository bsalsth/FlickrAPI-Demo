package com.softlica.bishal.myapplication.Di;

import android.app.Application;

import com.softlica.bishal.myapplication.Presenter.CalculatorPresenter;
import com.softlica.bishal.myapplication.Service.CalculatorService;
import com.softlica.bishal.myapplication.Service.FlickrService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

}
