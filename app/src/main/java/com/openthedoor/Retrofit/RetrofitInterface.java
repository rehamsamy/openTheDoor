package com.openthedoor.Retrofit;

import com.openthedoor.pojo.ChangePasswordResponse;
import com.openthedoor.pojo.UserResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {
   // https://www.openthedoor.app/api/login

   // "https://www.openthedoor.app/api/login?email=adel@gmail.com&password=123456"


   // "https://www.openthedoor.app/api/login?email=user2@gmail.com&password=123456s"


    @FormUrlEncoded
    @POST ("api/login")
    Call<UserResponse> loginUser(@FieldMap Map<String,String> map);





    @Multipart
    @POST("api/register")
    Call<UserResponse> registerUser(@QueryMap Map<String, Object> map, @Part MultipartBody.Part file);
   // Call<Response> uploadImage(@Part MultipartBody.Part image);

    @POST("api/changepassword?")
  Call<ChangePasswordResponse> changePassword(@QueryMap Map<String, Object> map);


    @Multipart
    @POST("api/updateprofile")
    Call<UserResponse> updateProfile(@QueryMap Map<String, Object> map, @Part MultipartBody.Part file);



    @GET("api/userinfo?")

    Call<UserResponse> getUserInfo(@QueryMap Map<String, Object> map);



}


