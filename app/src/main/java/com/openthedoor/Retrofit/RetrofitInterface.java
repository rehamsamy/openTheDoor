package com.openthedoor.Retrofit;

import com.openthedoor.pojo.ResponsePojo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface {
   // https://www.openthedoor.app/api/login

   // "https://www.openthedoor.app/api/login?email=adel@gmail.com&password=123456"


   // "https://www.openthedoor.app/api/login?email=user2@gmail.com&password=123456s"


    @FormUrlEncoded
    @POST ("api/login")
    Call<ResponsePojo> loginUser(@Field("email") String email, @Field("password") String password);




    @FormUrlEncoded
    @POST("api/{register}")
    Call<ResponsePojo> registerUser(@Path("register") String register,@FieldMap Map<String,Object> map);


}
