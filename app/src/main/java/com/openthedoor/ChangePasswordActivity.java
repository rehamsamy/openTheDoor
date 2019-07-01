package com.openthedoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePasswordActivity extends AppCompatActivity {

    @BindView(R.id.changePass_back_txtV_id)
    ImageView back;
    @BindView(R.id.old_password_ed_id)
    EditText oldPassword_ed;
    @BindView(R.id.new_password_ed_id)
    EditText newPassword_ed;
    @BindView(R.id.confirm_newPass_ed_id)
    EditText confirm_newPass_ed;
    @BindView(R.id.changePass_btn_id)
    Button changePass_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.changePass_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.changePass_btn_id)
    public void changrPassword() {


    }
}
