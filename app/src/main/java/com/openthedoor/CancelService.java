package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.CancellServiceResponse;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancelService extends AppCompatActivity {

    private static final String TAG ="CancelService" ;
    @BindView(R.id.cancelService_back_txtV_id) ImageView back;
    @BindView(R.id.cancel_service_reasons_ed) EditText reasons_ed;
    @BindView(R.id.cancel_service_button) Button cancelService_btn;
    RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_service);
        ButterKnife.bind(this);
        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();

    }

    @OnClick(R.id.cancelService_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.cancel_service_button)
    public void cancelService() {
       cancelServiceRetrofit();
    }

    private void cancelServiceRetrofit() {
        Map<String,Object> map=new HashMap<>();
        map.put("api_token",LoginActivity.userResponse.getToken());
        map.put("user_id",LoginActivity.user.getId());
        map.put("reson_for_cancel",reasons_ed.getText().toString());
        map.put("user_service_id",1);


        Call<CancellServiceResponse>  call=retrofitInterface.cancelService(map);
        call.enqueue(new Callback<CancellServiceResponse>() {
            @Override
            public void onResponse(Call<CancellServiceResponse> call, Response<CancellServiceResponse> response) {
                if(response.body().isStatus()){
                    Log.v(TAG,"cancel Serviceeeeeeeee"+response.body().toString());
                    Toast.makeText(CancelService.this,response.body().getMessages(), Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<CancellServiceResponse> call, Throwable t) {
                Log.v(TAG,"cancel Serviceeeeeeeee"+t.getMessage().toString());
            }
        });

    }


}
