package com.openthedoor.fragmentTabs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoor.Adapter.InProcessTabAdapter;
import com.openthedoor.NotesActivity;
import com.openthedoor.R;
import com.openthedoor.ReportProblemActivity;
import com.openthedoor.interfaces.RecyclerOnItemClickListner;

public class InProcessFragmentTab extends Fragment {

    static final String TAG = InProcessFragmentTab.class.getSimpleName();

    Context context;
    Dialog myDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_inprocess_tab, container, false);

        myDialog = new Dialog(getActivity());
        RecyclerView recyclerView = view.findViewById(R.id.inprocess_recycler);
        InProcessTabAdapter adapter = new InProcessTabAdapter(getContext());
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
        ImageView makeCall, cancelService_imageV;
        Button cancelService_btn;
        TextView givebonus, addNote, reportProblem;

        myDialog.setCancelable(true);
        myDialog.setContentView(R.layout.inprogress_popup_layout);
        makeCall = myDialog.findViewById(R.id.inProgressDetails_makeCall_icon_id);
        cancelService_btn = myDialog.findViewById(R.id.inprogressDetailse_endService_btn);
        cancelService_imageV = myDialog.findViewById(R.id.inProgress_cancelService_imageV);
        givebonus = myDialog.findViewById(R.id.inProgress_give_bonus);
        addNote = myDialog.findViewById(R.id.inProgress_add_notes);
        reportProblem = myDialog.findViewById(R.id.inProgress_report_proplem);

        cancelService_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), NotesActivity.class);
                startActivity(intent);
            }
        });

        reportProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ReportProblemActivity.class);
                startActivity(intent);
            }
        });

        myDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();



    }




}
