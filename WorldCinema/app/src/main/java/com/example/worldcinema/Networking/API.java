package com.example.worldcinema.Networking;

import com.example.worldcinema.Networking.RegUser.RegBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("/auth/register")
    Call<Void> regUser(@Body RegBody regBody);
}
