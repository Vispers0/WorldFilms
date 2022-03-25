package com.example.worldcinema.Networking;

import com.example.worldcinema.Networking.LogUser.LogBody;
import com.example.worldcinema.Networking.RegUser.RegBody;
import com.example.worldcinema.Networking.LogUser.LogResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("/auth/register")
    Call<Void> regUser(@Body RegBody regBody);

    @POST("/auth/login")
    Call<LogResponse> logUser(@Body LogBody logBody);
}
