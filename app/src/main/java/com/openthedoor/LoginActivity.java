package com.openthedoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.ResponsePojo;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    Toolbar toolbar;
    TextView sign_up;
    TextView forget_password;
   public static   final String baseUrl="https://www.openthedoor.app/";

   @BindView(R.id.phone_input_layout) TextInputLayout phoneInput;
   @BindView(R.id.confirm_password_input_layout) TextInputLayout passwordInput;

    Button sign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        forget_password=(TextView) findViewById(R.id.forget_password);
        sign_in=(Button) findViewById(R.id.sign_in);
        sign_up=(TextView) findViewById(R.id.sign_up);


//        final Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        final RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);



        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp2Activity.class));
            }
        });



        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ForgetPasswordActivity.class));
            }
        });



        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                        .build();

                RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

                Call<ResponsePojo> call=retrofitInterface.loginUser("user2@gmail.com","123456s");

                call.enqueue(new Callback<ResponsePojo>() {
                    @Override
                    public void onResponse(Call<ResponsePojo> call, retrofit2.Response<ResponsePojo> response) {
                        Log.v(TAG,"rrrrrrrrrr"+response.body());

                    }

                    @Override
                    public void onFailure(Call<ResponsePojo> call, Throwable t) {
                        Log.v(TAG,"errorrrrrrrr"+t.getMessage().toString()+phoneInput.getEditText().getText().toString());

                    }
                });


            }
        });










    }




}
