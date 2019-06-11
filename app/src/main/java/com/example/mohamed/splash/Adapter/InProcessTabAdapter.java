package com.example.mohamed.splash.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
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

import com.example.mohamed.splash.R;

public class InProcessTabAdapter  extends RecyclerView.Adapter<InProcessTabAdapter.Holder> {

    Context context;
    View view;

    public InProcessTabAdapter(Context mcontext){
        context=mcontext;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         view= LayoutInflater.from(context).inflate(R.layout.inprocess_item_list,viewGroup,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        //context=getContext();
       // Button button=(Button) view.findViewById(R.id.pop_up);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater1=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View customView=inflater1.inflate(R.layout.activity_in_process_pop_up,null);

                final PopupWindow window=new PopupWindow(customView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.setElevation(2);
                }


                ImageView imageView= (ImageView) customView.findViewById(R.id.cancel_service);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        window.dismiss();
                    }
                });

                ConstraintLayout rl=(ConstraintLayout) view.findViewById(R.id.cons);
                window.showAtLocation(rl, Gravity.CENTER,0,0);


            }
        });









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
