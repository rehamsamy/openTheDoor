package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.openthedoor.Adapter.PaginationAdapter;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.NotficationItem;
import com.openthedoor.pojo.UserNotificationResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationActivity extends AppCompatActivity {


    private static final String TAG ="NotificationActivity";
    @BindView(R.id.pagination_recycler) RecyclerView recyclerView;

    PaginationAdapter adapter;
    List<NotficationItem>  notficationItems;
    int userPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);

       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setHasFixedSize(true);


        getNotification(userPage);

        getMoreScroll();
    }

    private void getNotification(int page) {

        Retrofit retrofit=new Retrofit.Builder().baseUrl(LoginActivity.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        Map<String,Object> map=new HashMap<>();
       String token= LoginActivity.userResponse.getToken();
        map.put("user_id",LoginActivity.user.getId());
        map.put("api_token",token);
        map.put("page",1);
        map.put("limit",1);

      Call<UserNotificationResponse> call=retrofitInterface.getUserNotification(map);

      call.enqueue(new Callback<UserNotificationResponse>() {
          @Override
          public void onResponse(Call<UserNotificationResponse> call, Response<UserNotificationResponse> response) {
              Log.v("NotificationActivity","notifyyyyy"+response.body().toString());

              Boolean status=response.body().isStatus();
              if(status==true){

                  notficationItems=response.body().getNotfication();
                  notficationItems.addAll(response.body().getNotfication());
                  adapter.setTasks(notficationItems);
                  Log.v(TAG,"mmmmmmmmmmm"+notficationItems.size());
                  adapter.notifyItemRangeChanged(adapter.getItemCount(),notficationItems.size()-1);
              }
              else if(status==false){
                  Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
              }

          }

          @Override
          public void onFailure(Call<UserNotificationResponse> call, Throwable t) {
              Log.v("NotificationActivity","notifyyyyy"+t.getMessage());
          }
      });


    }

    private  void getMoreScroll() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // adapter=new PaginationAdapter(getApplicationContext(),notficationItems);
       // adapter.setTasks(notficationItems);
        recyclerView.setAdapter(adapter);
        Log.v(TAG,"mmmmmmmmmmm"+notficationItems.size());
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                userPage++;
                getNotification(userPage);

            }
        });
    }

}
