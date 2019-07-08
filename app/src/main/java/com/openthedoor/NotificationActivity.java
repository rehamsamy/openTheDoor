package com.openthedoor;

import android.app.Notification;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.openthedoor.Adapter.PaginationAdapter;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.DeleteNotificatioResponse;
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

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class NotificationActivity extends AppCompatActivity {


    private static final String TAG ="NotificationActivity";
    @BindView(R.id.pagination_recycler) RecyclerView recyclerView;

    List<NotficationItem> notficationItemList;
    PaginationAdapter adapter;
    int userPage=1;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        getNotification(userPage);
       // deleteNotification();
        swipRecycler();


    }



    private void getNotification(int page) {

        Retrofit retrofit=new Retrofit.Builder().baseUrl(LoginActivity.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        Map<String,Object> map=new HashMap<>();
       String token= LoginActivity.userResponse.getToken();
        map.put("user_id",LoginActivity.user.getId());
        map.put("api_token",token);
        map.put("page",page);
        map.put("limit",1);

      Call<UserNotificationResponse> call=retrofitInterface.getUserNotification(map);

      call.enqueue(new Callback<UserNotificationResponse>() {
          @Override
          public void onResponse(Call<UserNotificationResponse> call, Response<UserNotificationResponse> response) {
              Log.v("NotificationActivity","notifyyyyy"+response.body().toString());

              Boolean status=response.body().isStatus();
              if(status==true){
                  notficationItemList=response.body().getNotfication();

                  LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                  recyclerView.setLayoutManager(layoutManager);
                  recyclerView.setItemAnimator(new DefaultItemAnimator());
                  adapter=new PaginationAdapter(getApplicationContext(),response.body().getNotfication());
                  recyclerView.setAdapter(adapter);

                  DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
                  recyclerView.addItemDecoration(decoration);

                  recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
                      @Override
                      public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                          userPage++;
                          //getNotification(userPage);

                      }
                  });

            }
              else if(status==false){
                  Toast.makeText(getApplicationContext(),"Notficatio Is Empty",Toast.LENGTH_LONG).show();
              }

          }

          @Override
          public void onFailure(Call<UserNotificationResponse> call, Throwable t) {
              Log.v("NotificationActivity","notifyyyyy"+t.getMessage());
          }
      });



    }

    private void deleteNotification(int position) {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(LoginActivity.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);
        Map<String,Object> map=new HashMap<>();

       NotficationItem item= notficationItemList.get(position);
       int id=item.getId();
        map.put("not_id",id);
        map.put("api_token",LoginActivity.userResponse.getToken());
     Call<DeleteNotificatioResponse>call=   retrofitInterface.deleteUserNotification(map);
        call.enqueue(new Callback<DeleteNotificatioResponse>() {
            @Override
            public void onResponse(Call<DeleteNotificatioResponse> call, Response<DeleteNotificatioResponse> response) {
                Log.v(TAG,"delete notification"+response.body().toString());
                Toast.makeText(getApplicationContext(),response.body().getSuccessMsg(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DeleteNotificatioResponse> call, Throwable t) {

                Log.v(TAG,"delete notification"+t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });


    }



    private void swipRecycler() {

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
                position=viewHolder.getAdapterPosition();
                deleteNotification(position);
                Toast.makeText(getApplicationContext(),"sssssssss"+position,Toast.LENGTH_LONG).show();
            }
        }).attachToRecyclerView(recyclerView);

    }




}
