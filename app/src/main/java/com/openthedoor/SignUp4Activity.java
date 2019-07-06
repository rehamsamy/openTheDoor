package com.openthedoor;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.UserResponse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class SignUp4Activity extends AppCompatActivity {

    private static final String TAG = "SignUp4Activity";
    Toolbar toolbar;
    @BindView(R.id.phone_input_layout)TextInputLayout phoneInput;
    @BindView(R.id.signUp1_btn_id) MaterialButton continu;
    @BindView(R.id.upload) ImageView uploadImage;
    String path;
    InputStream inputStream;
    byte[] bytes;
    private String mImageUrl = "";

    Bitmap bitmap;

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


                uploadImage(bytes);
            }
        });


        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");

                // intent.setType("image/*");
               // startActivityForResult(Intent.createChooser(intent,"choose image"),1);

                startActivityForResult(intent,1);
            }

        });

    }

    private void uploadImage(byte[] imageBytes) {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(LoginActivity.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);
        Map<String,Object> map=new HashMap<>();
        String phone=phoneInput.getEditText().getText().toString().trim();
        map.put("name",name);
        map.put("password",password);
        map.put("email",email);
        map.put("password_confirmation", confirmPassword);
        map.put("phone",phone);

        String path="https://www.openthedoor.app/images/users/user/1562061634.add_image2.png";

//        File file=new File(path);
        final RequestBody requestBody=RequestBody.create(MediaType.parse("image/jpeg"),path);
        MultipartBody.Part part=MultipartBody.Part.createFormData("image", "user_image",requestBody);
        RequestBody desc=RequestBody.create(MediaType.parse("multipart/form-data"),"image-type");

        Call<UserResponse> call = retrofitInterface.registerUser(map,part);

        call.enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                Log.v("LoginActivity","rrrrrrrrrr"+response.body().toString());

                if (response.isSuccessful()) {

                    UserResponse responseBody = response.body();
                   // Log.v(TAG,"rrrrrrrrrrrrrrrrr"+requestBody.toString());
                    Intent intent=new Intent(getApplicationContext(),FindServiceActivity.class);
                    startActivity(intent);
                }



            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.v("LoginActivity","rrrrrrrrrr"+t.getMessage());

            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1&&resultCode==RESULT_OK){
            final Uri image=data.getData();
            //path= getPathFromUri(image);


            try {
                inputStream=getContentResolver().openInputStream(data.getData());

                 bytes=  getBytes(inputStream);
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),image);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public byte[] getBytes(InputStream is) throws IOException {
        ByteArrayOutputStream byteBuff = new ByteArrayOutputStream();

        int buffSize = 1024;
        byte[] buff = new byte[buffSize];

        int len = 0;
        while ((len = is.read(buff)) != -1) {
            byteBuff.write(buff, 0, len);
        }

        return byteBuff.toByteArray();
    }




    private String getPathFromUri(Uri uri){

        String[] projection={MediaStore.Images.Media.DATA};
        CursorLoader loader=new CursorLoader(getApplicationContext(),uri,projection,null,null,null);

        Cursor cursor=loader.loadInBackground();

        int column=cursor.getColumnIndex(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();
        String result=cursor.getString(column);
        cursor.close();
        return result;


    }
}
