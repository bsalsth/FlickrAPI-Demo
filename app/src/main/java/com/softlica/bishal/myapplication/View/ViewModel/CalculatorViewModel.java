package com.softlica.bishal.myapplication.View.ViewModel;

import com.softlica.bishal.myapplication.Model.Number;

import java.util.List;

/**
 * Created by bishal on 2/10/2017.
 */

public interface CalculatorViewModel extends BaseViewModel {
    public void showData(List<Number> data);
    public void showResult(String result);
}
