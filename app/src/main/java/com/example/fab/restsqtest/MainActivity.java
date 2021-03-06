package com.example.fab.restsqtest;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fab.restsqtest.API.SQApi;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//fghjkl;

public class MainActivity extends AppCompatActivity implements Callback<User> {

    Retrofit retrofit;
    SQApi testAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //logging

        retrofit = new Retrofit.Builder()
                .baseUrl("http://shopquest-rudolf.rhcloud.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        testAPI = retrofit.create(SQApi.class);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void sendUserData(View view) throws IOException {
        User user = new User();
        user.phone_number = ((EditText)findViewById(R.id.editTextPhone)).getText().toString();
        user.device_ident = "123";
        user.first_name = ((EditText)findViewById(R.id.editTextUserName)).getText().toString();
        user.password = ((EditText)findViewById(R.id.editTextPass)).getText().toString();
        user.password2 = ((EditText)findViewById(R.id.editTextPass2)).getText().toString();
        Call<User> call = testAPI.createUser(user);
        call.enqueue(this);
    }


    public void onResponse(Call<User> user, Response<User> response) {
        TextView responseText = (TextView) findViewById(R.id.ResponseText);
        try{
            responseText.setText(new Gson().toJson(response.body()));
        }
        catch (Exception e)
        {
            responseText.setText(e.toString());
        }
    }


    public void onFailure(Call<User> user, Throwable t) {
        Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
