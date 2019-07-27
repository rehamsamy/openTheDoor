package com.openthedoor;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.FavPlacesResponse;
import com.openthedoor.utils.CurrentLocation;
import com.openthedoor.utils.DialogUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindServiceActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private static final String TAG ="FindServiceActivity" ;
    private static final int LOCATION_REQUEST_CODE =1 ;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    android.support.v7.widget.Toolbar toolbar;
    Button findService_btn;
    @BindView(R.id.current_location) TextView current_location_txv;


      GoogleMap googleMap;
      int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_service);

        ButterKnife.bind(this);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        findService_btn = findViewById(R.id.find_service);
        navigationView = (NavigationView) findViewById(R.id.nv);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        findService_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindServiceActivity.this, SelectService.class));
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);



        init();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.profile:
                        drawerLayout.closeDrawers();
                        startActivity(new Intent(FindServiceActivity.this, ProfileActivity.class));
                        break;
                    case R.id.history:
                        drawerLayout.closeDrawers();
                        startActivity(new Intent(FindServiceActivity.this, HistoryActivity.class));
                        break;
                    case R.id.reviews:
                        drawerLayout.closeDrawers();
                        startActivity(new Intent(FindServiceActivity.this, Reviews.class));
                        break;
                    case R.id.payment:
                        drawerLayout.closeDrawers();
                        startActivity(new Intent(FindServiceActivity.this, PaymentActivity.class));
                        break;
                    case R.id.promocode:
                        drawerLayout.closeDrawers();
                        startActivity(new Intent(FindServiceActivity.this, AddReview.class));
                        break;
                    case R.id.notifications:
                        drawerLayout.closeDrawers();
                        startActivity(new Intent(FindServiceActivity.this,NotificationActivity.class));
                        break;
                    default:
                }
                return true;
            }
        });


    }




    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }


    @OnClick(R.id.log_out_sidemenu)
    void logOut() {
        drawerLayout.closeDrawers();
        Toast.makeText(this, "LogOut Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {

        }
        return true;
    }


   void postAddFavPlaces(){
      Retrofit retrofit=new Retrofit.Builder().baseUrl(LoginActivity.baseUrl).
              addConverterFactory(GsonConverterFactory.create())
              .build();

       RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

       Map<String,Object> map=new HashMap<>();
       map.put("fav_plac_title","home");
       map.put("fav_plac_address","haram,giza,egypt");
       map.put("fav_plac_long","5451.2312156161");
       map.put("fav_plac_lat","5451.2312156161");
     Call<FavPlacesResponse> call= retrofitInterface.addFavPlaces(map);

      call.enqueue(new Callback<FavPlacesResponse>() {
          @Override
          public void onResponse(Call<FavPlacesResponse> call, Response<FavPlacesResponse> response) {
              response.body().toString();
              Log.v("FindServiceActivity","places sssss"+ response.body().toString());
          }

          @Override
          public void onFailure(Call<FavPlacesResponse> call, Throwable t) {

              Log.v("FindServiceActivity","places sssss"+ t.getMessage() );
          }
      });
      }



    @Override
    public void onMapReady(GoogleMap googleMap1) {
        googleMap=googleMap1;
        DialogUtil.showMaterialDialog(this,getString(R.string.reminding),getString(R.string.reminding_content),
                getString(R.string.pos_mess),getString(R.string.neg_mess),null,null);
       CurrentLocation currentLocation= new CurrentLocation(googleMap,getApplicationContext(),current_location_txv);


        googleMap.setOnMyLocationButtonClickListener(currentLocation.onMyLocationButtonClickListener);
        CurrentLocation.enableMyLocationIfPermitted();
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setMinZoomPreference(10);
        googleMap.setOnMyLocationChangeListener(currentLocation.onMyLocationChangeListener);

    }

    private void init(){
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private void enableMyLocationIfPermitted() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION},LOCATION_REQUEST_CODE);
        }

        else if(googleMap!=null){
            googleMap.setMyLocationEnabled(true);
        }

    }


    private GoogleMap.OnMyLocationButtonClickListener locationButtonClickListener=
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    googleMap.setMaxZoomPreference(15);
                    Log.i(TAG,"location on Buttion listener");
                    return true;
                }
            };


    private GoogleMap.OnMyLocationChangeListener locationChangeListener=new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            if(flag==0){
                googleMap.clear();
                Geocoder geocoder=new Geocoder(FindServiceActivity.this);
                List<Address> addresses=null;
                try {
                    addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String address=addresses.get(0).getAddressLine(0);

                Log.v(TAG,"adddddddddd"+address);
               current_location_txv.setText(address);
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


}
