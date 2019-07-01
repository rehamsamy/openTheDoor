package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmationActivity extends AppCompatActivity {

    @BindView(R.id.serviceConfirmation_back_txtV_id)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.serviceConfirmation_back_txtV_id)
    public void setBack(){
        finish();
    }
}
