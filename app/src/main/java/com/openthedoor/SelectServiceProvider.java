package com.openthedoor;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.openthedoor.Adapter.ServiceProviderAdapter;
import com.openthedoor.interfaces.RecyclerOnItemClickListner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectServiceProvider extends AppCompatActivity {

    @BindView(R.id.serviceProvider_toolbar)
    Toolbar toolbar;
    @BindView(R.id.serviceProvider_recyclerV)
    RecyclerView providerRecycler;
    @BindView(R.id.serviceProvider_state_progress)
    StateProgressBar stateProgressBar;

    ServiceProviderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service_provider);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.nav_filter);
        toolbar.setOverflowIcon(drawable);

        providerRecycler.setLayoutManager(new LinearLayoutManager(this));
        providerRecycler.setHasFixedSize(true);

        adapter = new ServiceProviderAdapter(this);
        providerRecycler.setAdapter(adapter);

        // Handle Item Click Listner ...
        adapter.setItemClickListner(new RecyclerOnItemClickListner() {
            @Override
            public void OnItemClick(int position) {
                Toast.makeText(SelectServiceProvider.this, "Item.. " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SelectServiceProvider.this, ConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.service_provider_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nearest:
                startActivity(new Intent(SelectServiceProvider.this, ConfirmationActivity.class));
            case R.id.low_price:
                startActivity(new Intent(SelectServiceProvider.this, ConfirmationActivity.class));
                break;
            case R.id.high_rate:
                startActivity(new Intent(SelectServiceProvider.this, ConfirmationActivity.class));
                break;
            default:
        }
        return true;
    }
}
