package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.ChangePasswordResponse;
import com.openthedoor.pojo.UserResponse;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChangePasswordActivity extends AppCompatActivity {

    private static final String TAG ="ChangePasswordActivity" ;
    @BindView(R.id.changePass_back_txtV_id)
    ImageView back;
    @BindView(R.id.old_password_ed_id)
    EditText oldPassword_ed;
    @BindView(R.id.new_password_ed_id)
    EditText newPassword_ed;
    @BindView(R.id.confirm_newPass_ed_id)
    EditText confirm_newPass_ed;
    @BindView(R.id.changePass_btn_id)
    Button changePass_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);


       changrPassword();






    }

    @OnClick(R.id.changePass_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.changePass_btn_id)
    public void changrPassword() {

        String oldPassword=oldPassword_ed.getText().toString();
        String newPassword=newPassword_ed.getText().toString();
        String confirmPassword=confirm_newPass_ed.getText().toString();


       // Map<String,String> map=new HashMap<>();
        UserResponse response= LoginActivity.userResponse;

        String token=  response.getToken();
        int id=response.getUser().getId();

    Call<ChangePasswordResponse> call= RetrofitClientInstance.getRetrofitInstance().changePassword(id,
            oldPassword,confirmPassword,newPassword,token);

    call.enqueue(new Callback<ChangePasswordResponse>() {
        @Override
        public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
            Log.v(TAG,"changeeee"+response.body().toString());
            Boolean status=response.body().isStatus();
            if(status==true){
                Toast.makeText(getApplicationContext(),response.body().getMessages(),Toast.LENGTH_LONG).show();
            }
            else if(status==false){
                Toast.makeText(getApplicationContext(),response.body().getMessages(),Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
            Log.v(TAG,"changeeee"+t.getMessage());
        }
    });

    }
}
