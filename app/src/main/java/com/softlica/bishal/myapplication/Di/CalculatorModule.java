package com.softlica.bishal.myapplication.Di;

import android.app.Application;

import com.softlica.bishal.myapplication.Presenter.CalculatorPresenter;
import com.softlica.bishal.myapplication.Presenter.MapPresenter;
import com.softlica.bishal.myapplication.Service.CalculatorService;
import com.softlica.bishal.myapplication.View.ViewModel.CalculatorViewModel;
import com.softlica.bishal.myapplication.View.ViewModel.MapViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;



@Module
public class CalculatorModule {
 CalculatorViewModel view;
    public CalculatorModule(CalculatorViewModel view){
        this.view = view;
    }

    @Provides
    @CustomScope
    CalculatorViewModel provideView() {
        return view;
    }


    @Provides
    @CustomScope
    public CalculatorPresenter provideCalPresenter(CalculatorViewModel view){
        return  new CalculatorPresenter(view);
    }
}
