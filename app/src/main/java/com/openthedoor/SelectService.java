package com.openthedoor;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.ColorLong;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.isapanah.awesomespinner.AwesomeSpinner;
import com.openthedoor.utils.CurrentLocation;
import com.openthedoor.utils.DialogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectService extends AppCompatActivity implements OnMapReadyCallback {


    private static final String TAG ="SelectService" ;
    GoogleMap googleMap;
    @BindView(R.id.my_spinner)
    AwesomeSpinner spinner;
    @BindView(R.id.select_service_btn_id)
    Button select_service_btn;
    @BindView(R.id.current_location) TextView currentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service_activty);
        ButterKnife.bind(this);


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

        init();
    }


    @Override
    public void onMapReady(GoogleMap googleMap1) {
        googleMap=googleMap1;
        DialogUtil.showMaterialDialog(this,getString(R.string.reminding),getString(R.string.reminding_content),
                getString(R.string.pos_mess),getString(R.string.neg_mess),null,null);
     CurrentLocation  currentLocation= new CurrentLocation(googleMap,getApplicationContext(),currentTextView);


        googleMap.setOnMyLocationButtonClickListener(currentLocation.onMyLocationButtonClickListener);
       currentLocation.enableMyLocationIfPermitted();
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setMinZoomPreference(10);
        googleMap.setOnMyLocationChangeListener(locationChangeListener);
    }


    private void init(){
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private GoogleMap.OnMyLocationChangeListener locationChangeListener=new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            int flag=0;
            if(flag==0){
                googleMap.clear();
                Geocoder geocoder=new Geocoder(SelectService.this);
                List<Address> addresses=null;
                try {
                    addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String address=addresses.get(0).getAddressLine(0);

                Log.v(TAG,"adddddddddd"+address);
                currentTextView.setText(address);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(),location.getLongitude()))
                        .title(getString(R.string.current_location_map)).icon(BitmapDescriptorFactory.defaultMarker()));

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(),location.getLongitude())));

                flag=1;
            }
            else {
                Log.v(TAG,"add error");
            }
        }
    };


    @OnClick(R.id.select_service_btn_id)
    public void selectService() {

        Intent intent = new Intent(SelectService.this, SelectServiceProvider.class);
        startActivity(intent);
    }
}
