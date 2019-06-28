package com.openthedoor;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;

import com.openthedoor.Adapter.PaymentMethodAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentActivity extends AppCompatActivity {

    @BindView(R.id.paymentMethod_back_txtV_id)
    ImageView back;
    @BindView(R.id.payment_recyclerV_id)
    RecyclerView recyclerView;
    @BindView(R.id.add_payment_button)
    FloatingActionButton add_payment_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        // SET Adapter...
        PaymentMethodAdapter adapter = new PaymentMethodAdapter(PaymentActivity.this);
        recyclerView.setAdapter(adapter);

    }

    @OnClick(R.id.paymentMethod_back_txtV_id)
    public void setBack() {
        finish();
    }

    @OnClick(R.id.add_payment_button)
    public void addPayment() {
        Intent intent = new Intent(PaymentActivity.this, AddNewPayment.class);
        startActivity(intent);
    }
}
