package com.example.veljkodjordjevic.resupply.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.veljkodjordjevic.resupply.R;
import com.example.veljkodjordjevic.resupply.adapter.CharityAdapter;
import com.example.veljkodjordjevic.resupply.api.Api;
import com.example.veljkodjordjevic.resupply.api.RetrofitClient;
import com.example.veljkodjordjevic.resupply.model.ForgotPassword;
import com.example.veljkodjordjevic.resupply.model.LoginData;
import com.example.veljkodjordjevic.resupply.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {

        final String email = editEmail.getText().toString().trim();
        final String password = editPassword.getText().toString().trim();
        String scope = "app";
        String provider = "email";


        LoginData loginData = new LoginData(email, password, scope, provider);

        if (email.isEmpty()) {
            editEmail.setError("Email is required");
            editEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editPassword.setError("Password required");
            editPassword.requestFocus();
            return;
        }

        if (password.length() < 2) {
            editPassword.setError("Password should be atleast 2 character long");
            editPassword.requestFocus();
            return;
        }

/*
        Call<LoginResponse> call = RetrofitClient
                .getInstance().getApi().userLogin(loginData);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String e = email;
                String pass = password;
                LoginResponse loginResponse = response.body();

                if (loginResponse.getUser().getEmail().equals(email)) {

                     Intent intent = new Intent(LoginActivity.this, CharityActivity.class);
                     intent.putExtra("TOKEN", loginResponse.getRoles().get(0).getToken());
                     startActivity(intent);

                } else {
                    editEmail.setText("");
                    editPassword.setText("");
                    Toast.makeText(LoginActivity.this, "User is not allowed to request this scope", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Throwable tt = t;
                Toast.makeText(LoginActivity.this, "User is not allowed to request this scope", Toast.LENGTH_LONG).show();

            }
        }); */

        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX3JvbGVfaWQiOjkyOH0.aYnYKqPMbvH9Snlwn1Z2RjmYQCgjUWCj09EwpfaCm94";

        Intent intent = new Intent(LoginActivity.this, CharityActivity.class);
        intent.putExtra("TOKEN", token);
        startActivity(intent);
    }


    public void txtOnClick(View view) {

        Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);
        startActivity(intent);

    }
}
