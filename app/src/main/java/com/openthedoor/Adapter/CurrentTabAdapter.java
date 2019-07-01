package com.openthedoor.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openthedoor.R;
import com.openthedoor.interfaces.RecyclerOnItemClickListner;

public class CurrentTabAdapter extends RecyclerView.Adapter<CurrentTabAdapter.Holder> {

    Context context;
    private RecyclerOnItemClickListner itemClickListner;

    public CurrentTabAdapter(Context mcontext) {
        context = mcontext;
    }

    public void setOnItemClick(RecyclerOnItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @NonNull
    @Override
    public CurrentTabAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.current_item_list, viewGroup, false);
        return new Holder(view, itemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentTabAdapter.Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull final View itemView, final RecyclerOnItemClickListner listner) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listner != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listner.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
