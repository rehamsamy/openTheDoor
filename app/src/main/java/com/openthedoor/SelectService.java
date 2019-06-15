package com.openthedoor;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorLong;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.isapanah.awesomespinner.AwesomeSpinner;
import com.kofigyan.stateprogressbar.StateProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectService extends AppCompatActivity implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap googleMap;
    @BindView(R.id.my_spinner)
    AwesomeSpinner spinner;
    @BindView(R.id.select_service_btn_id)
    Button select_service_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service_activty);
        ButterKnife.bind(this);

        mapView = (MapView) findViewById(R.id.map_view);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }

        spinner.setSpinnerHint(getString(R.string.select_service));
        spinner.setHintTextColor(Color.GRAY);
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Ariplane");

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinner.setAdapter(categoriesAdapter);
        spinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {
                //TODO YOUR ACTIONS
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap1) {
        MapsInitializer.initialize(getApplicationContext());
        googleMap = googleMap1;
        googleMap1.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap1.addMarker(new MarkerOptions().position(new LatLng(40.45, -74.8888)).title("the place")
                .snippet("dddddddddddddddddd"));
        CameraPosition cameraPosition = CameraPosition.builder().target(new LatLng(40.45, -74.8888)
        ).zoom(16).bearing(0).tilt(45).build();

        googleMap1.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }


    @OnClick(R.id.select_service_btn_id)
    public void selectService() {

        Intent intent = new Intent(SelectService.this, SelectServiceProvider.class);
        startActivity(intent);
    }
}
