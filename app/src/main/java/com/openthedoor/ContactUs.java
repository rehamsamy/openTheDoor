package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class ContactUs extends AppCompatActivity {

    @BindView(R.id.contactus_back_txtV_id)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

    }

    @OnClick(R.id.contactus_back_txtV_id)
    public void setBack() {
        finish();
    }
}
