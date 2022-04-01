package com.example.watch;

import com.example.watch.LoginBody;
import com.example.watch.LoginResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

//Методы API, которые вызываются в проекте
public interface API {
    @POST("/auth/login")
    Call<LoginResponse> log_user(@Body LoginBody loginBody);

    @GET("/movies?filter=new")
    Call<List<FilmsResponse>> get_films();
}
