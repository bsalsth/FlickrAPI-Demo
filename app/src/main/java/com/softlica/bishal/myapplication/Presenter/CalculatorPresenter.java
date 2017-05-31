package com.softlica.bishal.myapplication.Presenter;

import android.util.Log;

import com.softlica.bishal.myapplication.Di.DaggerCalculatorComponent;
import com.softlica.bishal.myapplication.Di.DaggerServiceComponent;
import com.softlica.bishal.myapplication.Model.Number;
import com.softlica.bishal.myapplication.Service.CalculatorService;
import com.softlica.bishal.myapplication.View.ViewModel.CalculatorViewModel;
import com.softlica.bishal.myapplication.main.App;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by bishal on 2/9/2017.
 */

public class CalculatorPresenter implements BasePresenter{
    CalculatorViewModel view;
    CalculatorService service;
    List<Number> result;
    private int PORTRAIT_MODE = 1;
    private int LANDSCAPE_MODE = 2;
    @Inject
    public CalculatorPresenter( CalculatorViewModel view){
        this.view = view;
    }

    public void onCreate(){
       service = new CalculatorService();
        service.setListener(new CalculatorService.OperationListener() {

            @Override
            public void onSuccess() {
                result = service.getNumbers();

                view.showData(result);
                Log.d("onSuccess", result.size()+"");
            }

            @Override
            public void onFailure() {

            }
        });
        service.generateNumbers(24);
    }

    public void onPause(){

    }

    @Override
    public void onDestroy() {

    }

    public void onResume() {
        view.showData(result);
    }


    // Calculate result of the input
    public void calculateResult(Number number) {
        double result = service.calculateResult(number.getValue());
        view.showResult("Result : "+result);

    }


}
