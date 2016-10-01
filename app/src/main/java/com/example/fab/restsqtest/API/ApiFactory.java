package com.example.fab.restsqtest.API;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fab on 29.09.2016.
 */
public class ApiFactory {


    private static final OkHttpClient CLIENT = new OkHttpClient();

    @NonNull
    public static SQApi getSQApi(){
        return getRetrofit().create(SQApi.class);
    }
    @NonNull
    private static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://shopquest-rudolf.rhcloud.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(CLIENT)
                .build();
    }


}
