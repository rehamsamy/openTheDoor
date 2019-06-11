package com.example.mohamed.splash.fragmentTabs;

import android.content.Context;
import android.content.Intent;
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
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.mohamed.splash.Adapter.InProcessTabAdapter;
import com.example.mohamed.splash.R;
import com.example.mohamed.splash.popupWindow.InProcessPopUpActivity;

public class InProcessFragmentTab extends Fragment {

    static final String TAG=InProcessFragmentTab.class.getSimpleName();

    Context context;
    public InProcessFragmentTab() {
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view=  inflater.inflate(R.layout.fragment_inprocess_tab, container, false);

       RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.inprocess_recycler);
       InProcessTabAdapter adapter=new InProcessTabAdapter(getContext());
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       recyclerView.setAdapter(adapter);


       context=getContext();
        Button button=(Button) view.findViewById(R.id.pop_up);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Log.v(TAG,"eeeee");
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


       return view;

    }

  //  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    private void showPopUp(View view) {
//
//    View pop=LayoutInflater.from(getActivity()).inflate(R.layout.activity_in_process_pop_up,null);
//        final PopupWindow popupWindow = new PopupWindow(pop, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//
//       ImageView imageView= (ImageView)pop.findViewById(R.id.image);
//       imageView.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//             popupWindow.dismiss();
//           }
//       });
//    }


}
