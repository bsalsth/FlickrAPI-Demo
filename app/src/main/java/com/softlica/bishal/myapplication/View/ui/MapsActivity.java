package com.softlica.bishal.myapplication.View.ui;

import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.softlica.bishal.myapplication.Di.AppModule;
import com.softlica.bishal.myapplication.Di.CalculatorModule;
import com.softlica.bishal.myapplication.Di.DaggerMapComponent;
import com.softlica.bishal.myapplication.Di.DaggerNetComponent;
import com.softlica.bishal.myapplication.Di.MapComponent;
import com.softlica.bishal.myapplication.Di.MapModule;
import com.softlica.bishal.myapplication.Di.NetModule;
import com.softlica.bishal.myapplication.Model.PhotoItem;
import com.softlica.bishal.myapplication.Presenter.MapPresenter;
import com.softlica.bishal.myapplication.R;
import com.softlica.bishal.myapplication.Utility.Utility;
import com.softlica.bishal.myapplication.View.ViewModel.MapViewModel;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, MapViewModel, GoogleMap.OnMarkerClickListener {


    MapPresenter presenter;
    Boolean mapReady;
    private GoogleMap gMap;
    List<MarkerOptions> markers = Collections.emptyList();
    public static final int REQUEST_GOOGLE_PLAY_SERVICES = 1972;
    private SharedPreferences sharedPreferences;
    int locationCount = 0;
    SupportMapFragment mapFragment;
    List<PhotoItem> photoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        DaggerMapComponent.builder()
                .mapModule(new MapModule(this))
                .build();
        presenter.onCreate();
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mapReady = true;
        this.gMap = googleMap;

        googleMap.setOnMarkerClickListener(this);

        for(PhotoItem photo : photoItems) {
            Log.i("RETURNED PHOTOOS", photo.getLatitude() + " --- " + photo.getLongitude());
            LatLng location = Utility.getLatLng(photo.getLatitude(),photo.getLongitude());
            gMap.addMarker(new MarkerOptions()
                    .position(location)
                    .title(photo.getTitle())
                    .visible(true)
                    .snippet(photo.getownername()));
        }

        PhotoItem item = photoItems.get(0);
        LatLng goTo = Utility.getLatLng(item.getLatitude(), item.getLongitude());
            CameraPosition currentView = CameraPosition.builder()
                    .target(goTo)
                    .zoom(10)
                    .bearing(0)
                    .tilt(45)
                    .build();

            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(currentView));
    }

    // GET FLICK DATA TO SHOW IN MAP
    @Override
    public void showFlickData(List<PhotoItem> photos) {
        photoItems = photos;
        // Getting Google Play availability status
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int code = api.isGooglePlayServicesAvailable(this);
        if (code == ConnectionResult.SUCCESS) {
            mapFragment.getMapAsync(this);
        } else if (api.isUserResolvableError(code) &&
                api.showErrorDialogFragment(this, code, REQUEST_GOOGLE_PLAY_SERVICES)) {
        } else {
            Toast.makeText(this, api.getErrorString(code), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Snackbar.make(findViewById(android.R.id.content), marker.getSnippet(), Snackbar.LENGTH_LONG)
                .show();
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();

    }
}

