package com.softlica.bishal.myapplication.Di;

import android.view.View;

import com.softlica.bishal.myapplication.Presenter.CalculatorPresenter;
import com.softlica.bishal.myapplication.Presenter.MapPresenter;
import com.softlica.bishal.myapplication.View.ViewModel.CalculatorViewModel;
import com.softlica.bishal.myapplication.View.ViewModel.MapViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MapModule {
   private final MapViewModel view;

    public MapModule( MapViewModel view){
        this.view = view;
    }

    @Provides
    @CustomScope
    MapViewModel provideView() {
        return view;
    }


    @Provides
    @CustomScope
    public MapPresenter provideMapPresenter(MapViewModel view){
        return  new MapPresenter(view);
    }
}
