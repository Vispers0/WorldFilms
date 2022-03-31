package com.example.watch;

import com.example.watch.LoginBody;
import com.example.watch.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("/auth/login")
    Call<LoginResponse> log_user(@Body LoginBody loginBody);
}
