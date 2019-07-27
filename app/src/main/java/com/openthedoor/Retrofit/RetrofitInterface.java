package com.openthedoor.Retrofit;

import com.openthedoor.AddReview;
import com.openthedoor.HistoryActivity;
import com.openthedoor.pojo.AddReviewResponse;
import com.openthedoor.pojo.AllReviewsResponse;
import com.openthedoor.pojo.CancellServiceResponse;
import com.openthedoor.pojo.ChangePasswordResponse;
import com.openthedoor.pojo.DeleteNotificatioResponse;
import com.openthedoor.pojo.DeleteReviewResponse;
import com.openthedoor.pojo.EditReviewResponse;
import com.openthedoor.pojo.FavPlacesResponse;
import com.openthedoor.pojo.GeneralNotificationResponse;
import com.openthedoor.pojo.HistoryResponse;
import com.openthedoor.pojo.NotesResponse;
import com.openthedoor.pojo.ReportProblemResponse;
import com.openthedoor.pojo.UserNotificationResponse;
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
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {

    @FormUrlEncoded
    @POST ("api/login")
    Call<UserResponse> loginUser(@FieldMap Map<String,String> map);





    @Multipart
    @POST("api/register")
    Call<UserResponse> registerUser(@QueryMap Map<String, Object> map, @Part MultipartBody.Part file);
   // Call<Response> uploadImage(@Part MultipartBody.Part image);



    @POST("api/changepassword")
  Call<ChangePasswordResponse> changePassword(@Query("user_id") int id,
                                              @Query("current_password") String old,
                                              @Query("password_confirmation")String confirm,
                                              @Query("password")String Password,
                                              @Query("api_token")String api_token) ;


    @Multipart
    @POST("api/updateprofile")
    Call<UserResponse> updateProfile(@QueryMap Map<String, Object> map, @Part MultipartBody.Part file);



    @GET("api/userinfo?")

    Call<UserResponse> getUserInfo(@QueryMap Map<String, Object> map);


    @POST("api/addfavplaces")
    Call<FavPlacesResponse> addFavPlaces(@QueryMap Map<String, Object> map);



    @GET("api/getgeneralnotfication")
    Call<GeneralNotificationResponse> getGeneralNotification(@QueryMap Map<String, Object> map);


    @GET("api/usernotfication")
    Call<UserNotificationResponse> getUserNotification(@QueryMap Map<String, Object> map);



    @POST("api/deleteusernotfication")
    Call<DeleteNotificatioResponse> deleteUserNotification(@QueryMap Map<String, Object> map);



    @GET("api/getallreview")
    Call<AllReviewsResponse> getAllReviews(@QueryMap Map<String,Object> map);


    @POST("api/addreview")
    Call<AddReviewResponse>  addReview(@QueryMap Map<String,Object> map);


    @POST("api/deletereview")
    Call<DeleteReviewResponse> deleteReview(@QueryMap Map<String,Object> map);

    @POST("api/editreview")
    Call<EditReviewResponse> editReview(@QueryMap Map<String,Object> map);

    @GET("api/getuserservicehistory")
    Call<HistoryResponse> getServiceHistory(@QueryMap Map<String,Object> map);

    @POST("api/sendprovidernotes")
    Call<NotesResponse> sendProviderNotes(@QueryMap Map<String,Object> map);

    @POST("api/sendproblemreport")
    Call<ReportProblemResponse> sendReportProblem(@QueryMap Map<String,Object> map);


    @POST("api/cancelservice")
    Call<CancellServiceResponse> cancelService(@QueryMap Map<String,Object> map);

}


