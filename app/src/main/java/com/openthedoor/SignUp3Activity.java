package com.openthedoor;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp3Activity extends AppCompatActivity {
 Toolbar toolbar;
    Button sign_up;
    String name,email;
    @BindView(R.id.confirm_password_input_layout) TextInputLayout confirmPasswordInput;
    @BindView(R.id.phone_input_layout) TextInputLayout passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        email=intent.getStringExtra("email");

//        toolbar=(Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Sign Up");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sign_up=(Button) findViewById(R.id.signUp1_btn_id);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignUp4Activity.class);
                intent.putExtra("password",passwordInput.getEditText().toString());
                intent.putExtra("confirmPassword",confirmPasswordInput.getEditText().toString());
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
    }
}
