package com.openthedoor.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.design.button.MaterialButton;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoor.FindServiceActivity;
import com.openthedoor.R;

import java.io.IOException;
import java.util.List;


public class CurrentLocation {
    private static final int LOCATION_REQUEST_CODE = 1;
    static GoogleMap mMap;
    static Context mContext;
    public static String mAddress;
    public static TextView mTextView;
    static int flag=0;
    private static final String TAG = CurrentLocation.class.getSimpleName();

    public CurrentLocation(GoogleMap mMap, Context context, TextView textView) {
        this.mMap = mMap;
        this.mContext = context;
        this.mTextView=textView;
    }

    public static GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener = new GoogleMap.OnMyLocationButtonClickListener() {
        @Override
        public boolean onMyLocationButtonClick() {
            mMap.setMaxZoomPreference(15);
            Log.i(TAG, "location on Buttion listener");
            return true;
        }
    };

    public static GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            if(flag==0){
              mMap.clear();
                Geocoder geocoder=new Geocoder(mContext);
                List<Address> addresses=null;
                try {
                    addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String address=addresses.get(0).getAddressLine(0);

                Log.v(TAG,"adddddddddd"+address);
                mTextView.setText(address);
                mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(),location.getLongitude()))
                        .title(mContext.getString(R.string.current_location_map)).icon(BitmapDescriptorFactory.defaultMarker()));

                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(),location.getLongitude())));

                flag=1;
            }
            else {
                Log.v(TAG,"add error");
            }


  }
    };



    public static void enableMyLocationIfPermitted() {
        if (ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions((Activity) mContext, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);
        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }

    }

}
