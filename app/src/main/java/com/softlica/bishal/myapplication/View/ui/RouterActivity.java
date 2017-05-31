package com.softlica.bishal.myapplication.View.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.softlica.bishal.myapplication.R;
import com.softlica.bishal.myapplication.Service.FlickrService;
import com.softlica.bishal.myapplication.View.ui.CalculatorActivity;
import com.softlica.bishal.myapplication.View.ui.MapsActivity;

/**
 * Created by bishal on 2/10/2017.
 */

public class RouterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void calculatorClicked(View v) {
        Intent i = new Intent(this, CalculatorActivity.class);
        startActivity(i);
    }

    public void mapClicked(View v) {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}
