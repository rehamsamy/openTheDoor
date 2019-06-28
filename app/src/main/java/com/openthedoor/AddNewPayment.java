package com.openthedoor;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.openthedoor.fragmentTabs.PaymentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddNewPayment extends AppCompatActivity {

    @BindView(R.id.payment_tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.payment_view_pager)
    ViewPager viewPager;

    PaymentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_payment);
        ButterKnife.bind(this);

        adapter = new PaymentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        View view1 = getLayoutInflater().inflate(R.layout.tab_image_view, null);
        view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.mastercard_icon);
        tabLayout.getTabAt(0).setCustomView(view1);

        View view2 = getLayoutInflater().inflate(R.layout.tab_image_view, null);
        view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.visa_icon);
        tabLayout.getTabAt(1).setCustomView(view2);
    }

    @OnClick(R.id.addPayment_back_txtV_id)
    public void goBack() {
        finish();
    }
}
