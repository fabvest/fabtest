package com.example.fab.restsqtest.API;

import com.example.fab.restsqtest.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by fab on 29.09.2016.
 */
public interface SQApi {
    @POST("/api/create-user/")
    Call<User> createUser(@Body User user);


}
