package com.openthedoor.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openthedoor.R;
import com.openthedoor.interfaces.RecyclerOnItemClickListner;


public class ServiceProviderAdapter extends RecyclerView.Adapter<ServiceProviderAdapter.Holder> {

    private Context context;
    private RecyclerOnItemClickListner itemClickListner;

    public ServiceProviderAdapter(Context mContext) {
        context = mContext;
    }

    public void setItemClickListner(RecyclerOnItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.service_provider_list_item, viewGroup, false);
        return new Holder(view, itemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }


    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView, RecyclerOnItemClickListner listner) {
            super(itemView);

            if (listner != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listner.OnItemClick(position);
                }
            }
        }
    }
}
