package com.openthedoor;

import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.openthedoor.R;
import com.openthedoor.Retrofit.RetrofitClientInstance;
import com.openthedoor.Retrofit.RetrofitInterface;
import com.openthedoor.pojo.NotesResponse;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Callback;
import retrofit2.Response;

public class NotesActivity extends AppCompatActivity {

    private static final String TAG ="NotesActivity" ;
    @BindView(R.id.notes_input) TextInputLayout notesInput;
    @BindView(R.id.send_note) MaterialButton sendNoteButton;
    RetrofitInterface retrofitInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);
        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();

        sendNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotesService();
            }
        });

    }

    private void sendNotesService() {
        Map<String,Object> map=new HashMap<>();
        map.put("api_token",LoginActivity.userResponse.getToken());
        map.put("user_id",LoginActivity.user.getId());
        map.put("provider_id",1);
        map.put("notes",notesInput.getEditText().getText().toString());

        Log.v(TAG,"noooooo"+notesInput.getEditText().getText().toString());
        retrofit2.Call<NotesResponse> call= retrofitInterface.sendProviderNotes(map);
         call.enqueue(new Callback<NotesResponse>() {
             @Override
             public void onResponse(retrofit2.Call<NotesResponse> call, Response<NotesResponse> response) {
                if(response.body().isStatus()){
                    Toast.makeText(NotesActivity.this, response.body().getMessages(), Toast.LENGTH_SHORT).show();
                    Log.v(TAG,"notes"+response.body().toString());
                    notesInput.getEditText().setText("");
                }
             }

             @Override
             public void onFailure(retrofit2.Call<NotesResponse> call, Throwable t) {
                 Log.v(TAG,"notes"+t.getMessage().toString());

             }
         });


    }
}
