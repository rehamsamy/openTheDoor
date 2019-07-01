package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddReview extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.addReview_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.addReview_button)
    public void addReview() {

    }
}
