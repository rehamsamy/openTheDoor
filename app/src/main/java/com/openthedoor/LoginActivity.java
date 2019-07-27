package com.openthedoor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.User;
import com.openthedoor.pojo.UserResponse;
import com.openthedoor.utils.NetworkAvailable;


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

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    Toolbar toolbar;
    TextView sign_up;
    TextView forget_password;
    public static User user;
    public static UserResponse userResponse;

    NetworkAvailable available;
   public static   final String baseUrl="https://www.openthedoor.app/";

   @BindView(R.id.phone_input_layout) TextInputLayout phoneInput;
   @BindView(R.id.confirm_password_input_layout) TextInputLayout passwordInput;
    Button sign_in;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
          available=new NetworkAvailable(this);

        forget_password=(TextView) findViewById(R.id.forget_password);
        sign_in=(Button) findViewById(R.id.sign_in);
        sign_up=(TextView) findViewById(R.id.sign_up);

        preferences=getSharedPreferences("my_file",MODE_PRIVATE);
       phoneInput.getEditText().setText(preferences.getString("phone",null));
       passwordInput.getEditText().setText(preferences.getString("password",null));


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (available.isNetworkAvailable()) {
                    startActivity(new Intent(getApplicationContext(), SignUp2Activity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"make sure internet is connected !!",Toast.LENGTH_LONG).show();

                }
            }
        });



        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (available.isNetworkAvailable()) {
                    startActivity(new Intent(getApplicationContext(),ForgetPasswordActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"make sure internet is connected !!",Toast.LENGTH_LONG).show();

                }
                 }
        });



        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();

            }
        });


    }

    private void loginUser() {
        String phone=phoneInput.getEditText().getText().toString().trim();
        String password=passwordInput.getEditText().getText().toString().trim();



        if(available.isNetworkAvailable()) {
            Map<String, String> map = new HashMap<>();
            map.put("email", phone);
            map.put("password", password);

            Call<UserResponse> call = RetrofitClientInstance.getRetrofitInstance().loginUser(map);

            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    userResponse = response.body();
                    user = userResponse.getUser();
                    Boolean status = userResponse.isStatus();
                    if (status == true) {
                        Intent intent = new Intent(LoginActivity.this, FindServiceActivity.class);
                        intent.putExtra("user_data", user);
                        Log.v(TAG, "eeeeeeeeeeeee" + user.getEmail());
                        startActivity(intent);
                    } else if (status == false) {

                        Toast.makeText(getApplicationContext(), "make sure that your data is correct !!", Toast.LENGTH_LONG).show();
                    }

                    Log.v(TAG, "eeeeeeeeeeeee" + response.body().toString());
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {

                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(),"make sure internet is connected !!",Toast.LENGTH_LONG).show();
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        editor=preferences.edit();
      editor.putString("phone",phoneInput.getEditText().getText().toString());
      editor.putString("password",passwordInput.getEditText().getText().toString());
      editor.commit();
      editor.apply();

    }
}
