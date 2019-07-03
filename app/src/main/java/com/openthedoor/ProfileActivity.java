package com.openthedoor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.openthedoor.pojo.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.profile_back_txtV_id)
    ImageView back;
    @BindView(R.id.profile_userName_txtV)
    TextView userName_txtV;
    @BindView(R.id.profile_userPhone_txtV)
    TextView userPhone_txtV;
    @BindView(R.id.profile_userEmail_txtV)
    TextView userEmail_txtV;
    @BindView(R.id.edit_profile_date)
    Button editProfile_btn;
    @BindView(R.id.change_password)
    Button changePass_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

       // Intent intent=getIntent();
       User user= LoginActivity.user;
        String email=user.getEmail();
      String name=  user.getName();
      String phone= user.getPhone();


        userEmail_txtV.setText(email);
        userName_txtV.setText(name);
        userPhone_txtV.setText(phone);

    }

    @OnClick(R.id.edit_profile_date)
    public void editProfile() {
        startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
    }

    @OnClick(R.id.change_password)
    public void changePassword() {
        startActivity(new Intent(ProfileActivity.this, ChangePasswordActivity.class));
    }
}
