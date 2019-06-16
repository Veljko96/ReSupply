package com.example.veljkodjordjevic.resupply.api;

import com.example.veljkodjordjevic.resupply.model.CharitiesResponse;
import com.example.veljkodjordjevic.resupply.model.Charity;
import com.example.veljkodjordjevic.resupply.model.LoginData;
import com.example.veljkodjordjevic.resupply.model.LoginResponse;
import com.example.veljkodjordjevic.resupply.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @Headers("Content-Type: application/json")
    @POST("users/authenticate")
    Call<LoginResponse> userLogin(
            @Body LoginData loginData
            );

/* @Field("email") String email,
            @Field("password") String password,
            @Field("scope") String scope,
            @Field("provider") String provider */


    @GET("charities")
    Call<CharitiesResponse> getCharities(
            @Header("Authorization") String token,
            @Query("zip") String zip
    );

}
