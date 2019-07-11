package com.openthedoor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.AddReviewResponse;
import com.openthedoor.pojo.EditReviewResponse;
import com.openthedoor.pojo.ReviewsItem;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddReview extends AppCompatActivity {

    private static final String TAG ="AddReview" ;
    @BindView(R.id.addReview_back_txtV_id)
    ImageView back;
    @BindView(R.id.user_image)
    ImageView user_imageV;
    @BindView(R.id.user_name)
    TextView userName_txtV;
    @BindView(R.id.addReview_ratingBar_id)
    RatingBar ratingBar;
    @BindView(R.id.review_ed)
    EditText review_ed;
    @BindView(R.id.addReview_button)
    Button add_review_btn;
    RetrofitInterface retrofitInterface;
    String review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        if(intent==null){
            return;
        }else {
            ReviewsItem item = intent.getParcelableExtra("review_model");
            review = item.getNotes();
            userName_txtV.setText(item.getUserName());
            review_ed.setMaxLines(10);
            review_ed.setText(review);
           final String rev=review_ed.getText().toString();


            add_review_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editReview(rev);
                }
            });
        }

    }



    @OnClick(R.id.addReview_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.addReview_button)
    public void addReview() {
        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();
       String token= LoginActivity.userResponse.getToken();
        final String review=review_ed.getText().toString();
        Map<String,Object> map=new HashMap<>();
        map.put("notes",review);
        map.put("rate",ratingBar.getRating());
        map.put("api_token",token);
        map.put("provider_id",1);
        map.put("user_id",LoginActivity.userResponse.getUser().getId());
       Call<AddReviewResponse> call= retrofitInterface.addReview(map);
       call.enqueue(new Callback<AddReviewResponse>() {
           @Override
           public void onResponse(Call<AddReviewResponse> call, Response<AddReviewResponse> response) {
               Log.v(TAG,"add reviewwwwww"+response.body().toString());
               Toast.makeText(getApplicationContext(),response.body().getSuccessMsg(),Toast.LENGTH_LONG).show();
               review_ed.setText("");
           }

           @Override
           public void onFailure(Call<AddReviewResponse> call, Throwable t) {
               Log.v(TAG,"add reviewwwwww"+t.getMessage().toString());

           }
       });


    }

    private void editReview(String review) {
        retrofitInterface=RetrofitClientInstance.getRetrofitInstance();

        Intent intent=getIntent();
      ReviewsItem item= intent.getParcelableExtra("review_model");
        String note=item.getNotes();

        Map<String,Object> map=new HashMap<>();
        map.put("notes",review);
        map.put("rate",item.getRate());
        map.put("api_token",LoginActivity.userResponse.getToken());
        map.put("provider_id",item.getProviderId());
        map.put("user_id",LoginActivity.userResponse.getUser().getId());
        map.put("review_id",item.getId());
      Call<EditReviewResponse> call=  retrofitInterface.editReview(map);
      call.enqueue(new Callback<EditReviewResponse>() {
          @Override
          public void onResponse(Call<EditReviewResponse> call, Response<EditReviewResponse> response) {
              Log.v(TAG,"edit reviewwwww"+response.body().toString());
              Toast.makeText(getApplicationContext(),""+response.body().getSuccessMsg(),Toast.LENGTH_LONG).show();
          }

          @Override
          public void onFailure(Call<EditReviewResponse> call, Throwable t) {

          }
      });

    }

}
