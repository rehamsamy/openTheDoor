package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CancelService extends AppCompatActivity {

    @BindView(R.id.cancelService_back_txtV_id)
    ImageView back;
    @BindView(R.id.cancel_service_reasons_ed)
    EditText reasons_ed;
    @BindView(R.id.cancel_service_button)
    Button cancelService_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_service);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.cancelService_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.cancel_service_button)
    public void cancelService() {


    }
}
