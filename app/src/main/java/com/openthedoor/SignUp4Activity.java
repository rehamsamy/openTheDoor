package com.openthedoor;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.RegisterQuery;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp4Activity extends AppCompatActivity {

    Toolbar toolbar;
    @BindView(R.id.phone_input_layout)TextInputLayout phoneInput;
    @BindView(R.id.signUp1_btn_id) MaterialButton continu;

    String name,email,password,confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        password=intent.getStringExtra("password");
        email=intent.getStringExtra("email");
        confirmPassword=intent.getStringExtra("confirmPassword");





        continu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit=new Retrofit.Builder().baseUrl(LoginActivity.baseUrl)
                        .addConverterFactory(GsonConverterFactory.create()).build();

                RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);
                Map<String,Object> map=new HashMap<>();
                map.put("name","reham");
                map.put("password","123456");
                map.put("email","reham@gmail.com");
                map.put("confirmPassword","123456");
                map.put("phone",phoneInput.getEditText().getText().toString());

                Call<RegisterQuery>call= retrofitInterface.registerUser("register",map);

                call.enqueue(new Callback<RegisterQuery>() {
                    @Override
                    public void onResponse(Call<RegisterQuery> call, retrofit2.Response<RegisterQuery> response) {
                        Log.v("LoginActivity","rrrrrrrrrr"+response.body().toString());
                        Intent intent=new Intent(getApplicationContext(),FindServiceActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<RegisterQuery> call, Throwable t) {

                    }
                });



//                intent.putExtra("phone",phoneInput.getEditText().toString().trim());
//                intent.putExtra("name",name);
//                intent.putExtra("email",email);
//                intent.putExtra("password",password);
//                intent.putExtra("confirmPassword",confirmPassword);



            }
        });

    }




}
