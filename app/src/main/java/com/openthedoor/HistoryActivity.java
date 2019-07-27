package com.openthedoor;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.fragmentTabs.PagerAdapter;
import com.openthedoor.pojo.HistoryResponse;
import com.openthedoor.pojo.HistoryServiceModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    private static final String TAG ="HistoryActivity" ;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    RetrofitInterface retrofitInterface;
   public static HistoryResponse historyResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();
        getServiceHistory();
    }

    private void getServiceHistory() {
        final Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("limit",1);
        map.put("user_id",LoginActivity.user.getId());
        map.put("api_token",LoginActivity.userResponse.getToken());
        Call<HistoryResponse> call=retrofitInterface.getServiceHistory(map);
        call.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
              historyResponse=response.body();
              if(historyResponse.isStatus()){
                  //historyResponse.getUserserviceinfo().getCurrent();
                 // Log.v(TAG,"history"+historyResponse.getUserserviceinfo().getCurrent().get(0).getScheduleTime());
              }

            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {

            }
        });

    }
}
