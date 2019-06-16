package com.example.veljkodjordjevic.resupply.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.veljkodjordjevic.resupply.R;
import com.example.veljkodjordjevic.resupply.adapter.CharityAdapter;
import com.example.veljkodjordjevic.resupply.api.RetrofitClient;
import com.example.veljkodjordjevic.resupply.model.CharitiesResponse;
import com.example.veljkodjordjevic.resupply.model.Charity;
import com.example.veljkodjordjevic.resupply.model.Picture;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharityActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText editTextZip;
    private Button logOut;
    private String token;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity);

        final Bundle data = getIntent().getExtras();

        editTextZip = findViewById(R.id.zipId);
        logOut = findViewById(R.id.log_out);
        token = data.getString("TOKEN");

        editTextZip.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    initView();
                    return true;
                }
                return false;
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CharityActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);

        loadCharities();



    }

    private void loadCharities() {

        String zip = editTextZip.getText().toString().trim();

        /*Call<CharitiesResponse> call = RetrofitClient.getInstance().getApi().getCharities(token, zip);

        call.enqueue(new Callback<CharitiesResponse>() {
            @Override
            public void onResponse(Call<CharitiesResponse> call, Response<CharitiesResponse> response) {
                List<Charity> charities = response.body().getCharities();
                recyclerView.setAdapter(new CharityAdapter(getApplicationContext(), charities));
                recyclerView.smoothScrollToPosition(0);
            }

            @Override
            public void onFailure(Call<CharitiesResponse> call, Throwable t) {
                Toast.makeText(CharityActivity.this, "Error!!!", Toast.LENGTH_LONG).show();
            }
        });*/

        List<Charity> charities = new ArrayList<>();
        charities.add(new Charity("veljko test", new Picture(1, "https://www.canadahelps.org/media/charity_clipart.jpg"), 3, 5, null));
        charities.add(new Charity("srbija test", new Picture(2, "https://cdn.deliciousbrains.com/content/uploads/2015/12/15000806/photo-1421091242698-34f6ad7fc088-1540x1029.jpeg"), 5, 15, null));
        charities.add(new Charity("nesto test", new Picture(3, "https://www.inquirer.com/resizer/0peAB47BNKydwgwzMxjN1dyNbAk=/1400x932/smart/arc-anglerfish-arc2-prod-pmn.s3.amazonaws.com/public/D2LTRFIHZZEXTAJ55QIZBWGJEU.jpg"), 2, 6, null));
        charities.add(new Charity("charity test", new Picture(4, "https://cdn.deliciousbrains.com/content/uploads/2015/12/15000806/photo-1421091242698-34f6ad7fc088-1540x1029.jpeg"), 3, 8, null));
        charities.add(new Charity("charity2 test", new Picture(5, "https://cdn.deliciousbrains.com/content/uploads/2015/12/15000806/photo-1421091242698-34f6ad7fc088-1540x1029.jpeg"), 4, 20, null));
        recyclerView.setAdapter(new CharityAdapter(getApplicationContext(), charities));
        recyclerView.smoothScrollToPosition(0);
    }

}
