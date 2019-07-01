package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.openthedoor.Adapter.ReviewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Reviews extends AppCompatActivity {

    @BindView(R.id.review_recycler)
    RecyclerView review_recycler;
    ReviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        ButterKnife.bind(this);

        adapter = new ReviewAdapter(this);
        review_recycler.setLayoutManager(new LinearLayoutManager(this));
        review_recycler.setAdapter(adapter);
    }

    @OnClick(R.id.reviews_back_txtV_id)
    public void goBack() {
        finish();
    }
}
