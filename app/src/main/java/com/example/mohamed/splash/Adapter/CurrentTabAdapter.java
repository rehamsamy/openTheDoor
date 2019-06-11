package com.example.mohamed.splash.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohamed.splash.R;

public class CurrentTabAdapter  extends RecyclerView.Adapter<CurrentTabAdapter.Holder> {

    Context context;


    public CurrentTabAdapter(Context mcontext){
        context=mcontext;
    }
    @NonNull
    @Override
    public CurrentTabAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.current_item_list,viewGroup,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentTabAdapter.Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Holder  extends RecyclerView.ViewHolder{
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
