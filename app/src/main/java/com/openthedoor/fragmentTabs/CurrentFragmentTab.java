package com.openthedoor.fragmentTabs;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoor.Adapter.CurrentTabAdapter;
import com.openthedoor.CancelService;
import com.openthedoor.R;
import com.openthedoor.interfaces.RecyclerOnItemClickListner;

public class CurrentFragmentTab extends Fragment {

    Dialog myDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_current_tab, container, false);

        myDialog = new Dialog(getActivity());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.current_recycler);
        CurrentTabAdapter adapter = new CurrentTabAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClick(new RecyclerOnItemClickListner() {
            @Override
            public void OnItemClick(int position) {
                show_popup(position);
            }
        });

        return view;
    }


    private void show_popup(final int position) {
        ImageView makeCall;
        Button cancelService_btn;
        MapView mapView;
        GoogleMap googleMap;

        myDialog.setCancelable(true);
        myDialog.setContentView(R.layout.current_popup_layout);
        makeCall = myDialog.findViewById(R.id.currentDetails_makeCall_icon_id);
        cancelService_btn = myDialog.findViewById(R.id.currentDetailse_endService_btn);
        mapView = myDialog.findViewById(R.id.currentDetails_mapView);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    googleMap = googleMap;
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(40.45, -74.8888)).title("the place"));
                    CameraPosition cameraPosition = CameraPosition.builder().target(new LatLng(40.45, -74.8888)
                    ).zoom(16).bearing(0).tilt(45).build();
                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            });
        }
        cancelService_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CancelService.class);
                startActivity(intent);
                myDialog.dismiss();
                Toast.makeText(getActivity(), "Cancel Service ..." + position, Toast.LENGTH_SHORT).show();
            }
        });
        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                Toast.makeText(getActivity(), "Make Call ..." + position, Toast.LENGTH_SHORT).show();
            }
        });

        myDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
