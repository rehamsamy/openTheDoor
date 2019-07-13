package com.openthedoor;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp2Activity extends AppCompatActivity {

    MaterialButton signUp1_btn;
    TextView login_txtV;

    @BindView(R.id.phone_input_layout) TextInputLayout nameInput;
    @BindView(R.id.confirm_password_input_layout) TextInputLayout emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        ButterKnife.bind(this);

        signUp1_btn = findViewById(R.id.signUp1_btn_id);
        login_txtV = findViewById(R.id.login_txtV_id);

        signUp1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SignUp3Activity.class);
                intent.putExtra("name",nameInput.getEditText().getText().toString().trim());
                intent.putExtra("email",emailInput.getEditText().getText().toString().trim());
                startActivity(intent);

            }
        });

        login_txtV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FindServiceActivity.class));
                //finish();
            }
        });
    }
}
