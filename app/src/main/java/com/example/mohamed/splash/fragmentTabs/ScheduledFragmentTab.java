package com.example.mohamed.splash.fragmentTabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohamed.splash.Adapter.InProcessTabAdapter;
import com.example.mohamed.splash.Adapter.ScheduledTabAdapter;
import com.example.mohamed.splash.R;

public class ScheduledFragmentTab extends Fragment {

    Context context;
    public ScheduledFragmentTab() {
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.fragment_scheduled_tab, container, false);

        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.scheduled_recycler);
        ScheduledTabAdapter adapter=new ScheduledTabAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);



        return view;
    }
}
