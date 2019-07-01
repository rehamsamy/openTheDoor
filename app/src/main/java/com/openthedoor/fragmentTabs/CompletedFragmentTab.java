package com.openthedoor.fragmentTabs;

import android.app.Dialog;
import android.graphics.Color;
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
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoor.Adapter.CompletedTabAdapter;
import com.openthedoor.R;
import com.openthedoor.interfaces.RecyclerOnItemClickListner;

public class CompletedFragmentTab extends Fragment {

    Dialog myDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed_tab, container, false);

        myDialog = new Dialog(getActivity());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.completed_recycler);
        CompletedTabAdapter adapter = new CompletedTabAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.setItemClickListner(new RecyclerOnItemClickListner() {
            @Override
            public void OnItemClick(int position) {
                show_popup(position);
            }
        });

        return view;
    }


    private void show_popup(final int position) {
        ImageView makeCall;
        Button reorderService_btn;

        myDialog.setCancelable(true);
        myDialog.setContentView(R.layout.completed_popup_layout);
        makeCall = myDialog.findViewById(R.id.completeDetails_makeCall_icon_id);
        reorderService_btn = myDialog.findViewById(R.id.completeDetailse_reorderService_btn);

        reorderService_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                Toast.makeText(getActivity(), "reorder Service ..." + position, Toast.LENGTH_SHORT).show();
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
