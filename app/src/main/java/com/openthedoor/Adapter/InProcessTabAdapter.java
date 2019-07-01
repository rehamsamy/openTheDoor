package com.openthedoor.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.openthedoor.R;
import com.openthedoor.interfaces.RecyclerOnItemClickListner;

public class InProcessTabAdapter extends RecyclerView.Adapter<InProcessTabAdapter.Holder> {

    Context context;
    private RecyclerOnItemClickListner itemClickListner;

    public InProcessTabAdapter(Context mcontext) {
        context = mcontext;
    }

    public void setItemClickListner(RecyclerOnItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.inprocess_item_list, viewGroup, false);
        return new Holder(view, itemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView, final RecyclerOnItemClickListner listner) {
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
