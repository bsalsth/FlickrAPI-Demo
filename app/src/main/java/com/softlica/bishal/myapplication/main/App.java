package com.softlica.bishal.myapplication.main;

import android.app.Application;
import android.location.Location;


import com.softlica.bishal.myapplication.Di.AppModule;
import com.softlica.bishal.myapplication.Di.CalculatorComponent;
import com.softlica.bishal.myapplication.Di.DaggerNetComponent;
import com.softlica.bishal.myapplication.Di.NetComponent;
import com.softlica.bishal.myapplication.Di.NetModule;

import java.util.Collections;
import java.util.List;

public class App extends Application {
    private static App sInstance;
    private static NetComponent netComponent;
    private static CalculatorComponent calculatorComponent;
    public static Location currentLocation;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();


    }

    public static App getInstance() {
        return sInstance;
    }

    public static NetComponent getNetComponent() {
        return netComponent;
    }
}
