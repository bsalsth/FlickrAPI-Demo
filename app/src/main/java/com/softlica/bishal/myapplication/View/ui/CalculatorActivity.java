package com.softlica.bishal.myapplication.View.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.softlica.bishal.myapplication.Adapter.CustomAdapter;
import com.softlica.bishal.myapplication.Di.CalculatorModule;
import com.softlica.bishal.myapplication.Di.DaggerCalculatorComponent;
import com.softlica.bishal.myapplication.Model.Number;
import com.softlica.bishal.myapplication.Presenter.CalculatorPresenter;
import com.softlica.bishal.myapplication.R;
import com.softlica.bishal.myapplication.View.ViewModel.CalculatorViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class CalculatorActivity extends AppCompatActivity implements CalculatorViewModel, CustomAdapter.OnClickListener {
   @Inject
    CalculatorPresenter presenter;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    List<Integer> list;
    private TextView resultTextView;
    String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate);
        resultTextView = (TextView) findViewById(R.id.result);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new CustomAdapter(this);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Portrait Mode
            recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        } else {
            // Landscape Mode
            recyclerView.setLayoutManager(new GridLayoutManager(this, 7));
        }
        recyclerView.setAdapter(adapter);

        DaggerCalculatorComponent.builder()
                .calculatorModule(new CalculatorModule(this))
                .build();
        presenter.onCreate();

//

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showData(List<Number> data) {
        adapter.setData(data);
        adapter.setListener(this);
    }

    @Override
    public void showResult(String result) {

        resultTextView.setText(result);
    }


    @Override
    public void onCutomAdapterClick(Number number, int position) {
        resultTextView.setText("");
        presenter.calculateResult(number);
    }
}
