package com.openthedoor;

import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.ReportProblemResponse;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportProblemActivity extends AppCompatActivity {

    @BindView(R.id.report_proplem_btn) MaterialButton reportBtn;
    @BindView(R.id.report_problem_input_layout) TextInputLayout  problemInput;
    RetrofitInterface retrofitInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_problem);
        ButterKnife.bind(this);
        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();

         reportBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
              reportProblem();
             }
         });

    }

    private void reportProblem() {
        Map<String,Object> map=new HashMap<>();
        map.put("api_token",LoginActivity.userResponse.getToken());
        map.put("user_id",LoginActivity.user.getId());
        map.put("provider_id",1);
        map.put("problem",problemInput.getEditText().getText().toString());

        Call<ReportProblemResponse> call=retrofitInterface.sendReportProblem(map);
        call.enqueue(new Callback<ReportProblemResponse>() {
            @Override
            public void onResponse(Call<ReportProblemResponse> call, Response<ReportProblemResponse> response) {
               if(response.body().isStatus()){
                   Toast.makeText(ReportProblemActivity.this, response.body().getMessages(), Toast.LENGTH_SHORT).show();
                   problemInput.getEditText().setText("");
               }
            }

            @Override
            public void onFailure(Call<ReportProblemResponse> call, Throwable t) {

            }
        });

    }

}
