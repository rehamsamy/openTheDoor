package com.openthedoor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.openthedoor.Adapter.PaginationAdapter;
import com.openthedoor.Adapter.ReviewAdapter;
import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.interfaces.RecyclerOnItemClickListner;
import com.openthedoor.pojo.AllReviewsResponse;
import com.openthedoor.pojo.DeleteReviewResponse;
import com.openthedoor.pojo.ReviewsItem;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class Reviews extends AppCompatActivity implements ReviewAdapter.OnItemInterface{

    private static final String TAG = "Reviews";
    @BindView(R.id.review_recycler)
    RecyclerView review_recycler;
    @BindView(R.id.user_name) TextView userName;
    @BindView(R.id.user_image) ImageView userImage;
    PaginationAdapter paginationAdapter;
    ReviewAdapter adapter;
    RetrofitInterface retrofitInterface;
    List<ReviewsItem> reviews;
    ReviewsItem item;
    int page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        ButterKnife.bind(this);


        review_recycler.setLayoutManager(new LinearLayoutManager(this));
        getAllReviews(page);
    }



    @OnClick(R.id.reviews_back_txtV_id)
    public void goBack() {
        finish();
    }

    private void getAllReviews(int page) {
       retrofitInterface=RetrofitClientInstance.getRetrofitInstance();
        Map<String,Object> map=new HashMap<>();
        String token=LoginActivity.userResponse.getToken();
        map.put("page",1);
        map.put("limit",10);
        map.put("api_token",token);
      Call<AllReviewsResponse> call= retrofitInterface.getAllReviews(map);

      call.enqueue(new Callback<AllReviewsResponse>() {
          @Override
          public void onResponse(Call<AllReviewsResponse> call, Response<AllReviewsResponse> response) {
              Log.v(TAG,"reviewwww"+response.body().toString());
            AllReviewsResponse reviewsResponse=  response.body();
             reviews=reviewsResponse.getReviews();

            LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext());
            review_recycler.setLayoutManager(manager);
            review_recycler.setItemAnimator(new DefaultItemAnimator());
              adapter=new ReviewAdapter(getApplicationContext(),reviews,Reviews.this);
              Log.v(TAG,"reviewwww"+reviews.size());
              review_recycler.setAdapter(adapter);

              userName.setText(reviews.get(0).getUserName());
              Picasso.get().load(reviews.get(0).getUserImage()).placeholder(R.drawable.review_user_pic).into(userImage);

              DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
              review_recycler.addItemDecoration(decoration);

              review_recycler.addOnScrollListener(new EndlessRecyclerViewScrollListener(manager) {
                  @Override
                  public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                     page++;
                  }
              });



          }

          @Override
          public void onFailure(Call<AllReviewsResponse> call, Throwable t) {

          }
      });


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
            menu.setHeaderTitle("choose action:");
            menu.setHeaderIcon(R.drawable.login_icon);
        getMenuInflater().inflate(R.menu.popup_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.delete_review:
                deleteReview();
                return true;
            case R.id.edit_review:
                editReview();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onItemClick(int position, ReviewAdapter.Holder holder) {

        item= reviews.get(position);

        registerForContextMenu(holder.itemView);


    }




    private void editReview() {

        Intent intent=new Intent(Reviews.this,AddReview.class);
       intent.putExtra("review_model",item);
        startActivity(intent);


    }

    private void deleteReview() {
        retrofitInterface=RetrofitClientInstance.getRetrofitInstance();
        Map<String,Object>map=new HashMap<>();

        map.put("review_id",item.getId());
        map.put("api_token",LoginActivity.userResponse.getToken());
       Call<DeleteReviewResponse>call= retrofitInterface.deleteReview(map);
       call.enqueue(new Callback<DeleteReviewResponse>() {
           @Override
           public void onResponse(Call<DeleteReviewResponse> call, Response<DeleteReviewResponse> response) {
               Log.v(TAG,"delete reviewwwwwww"+response.body().toString());
               Toast.makeText(getApplicationContext(), ""+response.body().getSuccessMsg(), Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onFailure(Call<DeleteReviewResponse> call, Throwable t) {

           }
       });


    }
}
