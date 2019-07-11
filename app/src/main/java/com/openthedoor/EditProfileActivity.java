package com.openthedoor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.UserResponse;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditProfileActivity extends AppCompatActivity {

    @BindView(R.id.editProfile_back_txtV_id)
    ImageView back;
    @BindView(R.id.profile_add_imageV)
    ImageView add_imageV;
    @BindView(R.id.profile_user_imageV)
    ImageView user_imageV;
    @BindView(R.id.edit_userName_ed)
    EditText userName_ed;
    @BindView(R.id.edit_userEmail_ed)
    EditText userEmail_ed;
    @BindView(R.id.edit_userPhone_ed)
    EditText userPhone_ed;
    @BindView(R.id.save_editing_btn)
    Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.editProfile_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.profile_add_imageV)
    public void addImage() {

    }

    @OnClick(R.id.save_editing_btn)
    public void saveData() {

         Map<String,Object> map=new HashMap<>();

        String userName=userName_ed.getText().toString();
        String userEmail=userEmail_ed.getText().toString();
        String userPhone=userPhone_ed.getText().toString();

      UserResponse userResponse=  LoginActivity.userResponse;

      String token=userResponse.getToken();

        map.put("name",userName);
        map.put("email",userEmail);
        map.put("phone",userPhone);
        map.put("api_token",token);
        map.put("user_id",userResponse.getUser().getId());

        //"https://www.openthedoor.app/images/users/user/1562061634.add_image2.png"

//        File file=new File(path);
        final RequestBody requestBody=RequestBody.create(MediaType.parse("image/jpeg"),"https://www.openthedoor.app/images/users/user/1562061634.add_image2.png");
        MultipartBody.Part part=MultipartBody.Part.createFormData("user_image", "name",requestBody);
        RequestBody desc=RequestBody.create(MediaType.parse("multipart/form-data"),"image-type");

        Call<UserResponse> call = RetrofitClientInstance.getRetrofitInstance().updateProfile(map,part);

        call.enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                Log.v("LoginActivity","rrrrrrrrrr"+response.body().toString());

                if (response.isSuccessful()) {

                    UserResponse responseBody = response.body();
                    // Log.v(TAG,"rrrrrrrrrrrrrrrrr"+requestBody.toString());

                }



            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.v("LoginActivity","rrrrrrrrrr"+t.getMessage());

            }
        });

    }
}