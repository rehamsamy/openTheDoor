package com.openthedoor.Retrofit;

import com.openthedoor.pojo.Query;
import com.openthedoor.pojo.RegisterQuery;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
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
    Call<List<Query>> loginUser(@FieldMap Map<String,String> map);




    @FormUrlEncoded
    @POST("api/{register}")
    Call<RegisterQuery> registerUser(@Path("register") String register, @FieldMap Map<String,Object> map);


}
