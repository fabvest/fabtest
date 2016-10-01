package com.example.fab.restsqtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.fab.restsqtest.API.SQApi;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthorizationActivity extends AppCompatActivity {

    Retrofit retrofit;
    SQApi testAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://shopquest-rudolf.rhcloud.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        testAPI = retrofit.create(SQApi.class);
    }

//    @Override
    public void sendUserData(View view) throws IOException{
        //TODO authorizatoin

        Intent intent = new Intent(this, menuActivity.class);
        startActivity(intent);
    }

    public void onClick(View view) throws IOException{
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
