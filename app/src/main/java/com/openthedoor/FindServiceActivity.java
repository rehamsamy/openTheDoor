package com.openthedoor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.FavPlacesResponse;

import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindServiceActivity extends AppCompatActivity implements OnMapReadyCallback {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    android.support.v7.widget.Toolbar toolbar;

    MapView mapView;
    GoogleMap googleMap;
    Button findService_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_service);

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

      //  postAddFavPlaces();

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        mapView = (MapView) findViewById(R.id.map_view);


        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }


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


    @Override
    public void onMapReady(GoogleMap googleMap1) {
        MapsInitializer.initialize(getApplicationContext());
        googleMap = googleMap1;
        googleMap1.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap1.addMarker(new MarkerOptions().position(new LatLng(40.45, -74.8888)).title("the place"));
        CameraPosition cameraPosition = CameraPosition.builder().target(new LatLng(40.45, -74.8888)).zoom(16).bearing(0).tilt(45).build();
        googleMap1.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
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
//       map.put("user_id",LoginActivity.user.getId());
//       map.put("api_token",LoginActivity.userResponse.getToken());


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


}