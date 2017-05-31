package com.softlica.bishal.myapplication.Service;

import com.softlica.bishal.myapplication.Model.Number;
import com.softlica.bishal.myapplication.Utility.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bishal on 2/9/2017.
 */

public class CalculatorService {
    List<Number> numbers;

    public void setListener(OperationListener listener) {
        this.listener = listener;
    }

    private OperationListener listener;
    public CalculatorService(){
        numbers = new ArrayList<>();
        this.listener = listener;

    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }


    public void generateNumbers(int target){

        for(int i = 1; i <= target; i++){
            numbers.add(new Number(i));
        }
        listener.onSuccess();
    }

    public double calculateResult(int value) {
        return value + Constant.CALCULATE_VALUE;
    }

    public interface OperationListener{
        public void onSuccess();
        public void onFailure();

    }
}
