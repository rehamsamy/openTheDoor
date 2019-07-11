package com.openthedoor.Retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance  {

    private  static Retrofit retrofit=null;
    private static String base_url="https://www.openthedoor.app/";


    public static RetrofitInterface getRetrofitInstance(){
        if (retrofit==null){
            HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client=new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120,TimeUnit.SECONDS)
                    .connectTimeout(120,TimeUnit.SECONDS)
                    .build();



            retrofit=new Retrofit.Builder().
                    baseUrl(base_url).
                    client(client).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
       RetrofitInterface api=retrofit.create(RetrofitInterface.class);

        return api;
    }

}
