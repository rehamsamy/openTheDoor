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

public class EditProfileActivity extends AppCompatActivity {

    @BindView(R.id.editProfile_back_txtV_id)
    ImageView back;
    @BindView(R.id.profile_add_imageV)
    ImageView add_imageV;
    @BindView(R.id.profile_user_imageV)
    ImageView user_imageV;
    @BindView(R.id.edit_userName_ed)
    EditText userName_ed;
    @BindView(R.id.edit_userEmail_ed)
    EditText userEmail_ed;
    @BindView(R.id.edit_userPhone_ed)
    EditText userPhone_ed;
    @BindView(R.id.save_editing_btn)
    Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.editProfile_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.profile_add_imageV)
    public void addImage() {

    }

    @OnClick(R.id.save_editing_btn)
    public void saveData() {


    }
}