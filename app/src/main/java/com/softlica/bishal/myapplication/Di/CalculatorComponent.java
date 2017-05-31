package com.softlica.bishal.myapplication.Di;


import com.softlica.bishal.myapplication.Service.FlickrService;
import com.softlica.bishal.myapplication.View.ui.CalculatorActivity;

import javax.inject.Singleton;

import dagger.Component;


@CustomScope
@Component(modules = {CalculatorModule.class})
public interface CalculatorComponent {

    void inject(CalculatorActivity activity);

}
