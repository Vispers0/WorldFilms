package com.example.worldcinema.Networking.RegUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Server {
    @POST("auth/register")
    Call<List<RegModel>> regUser(@Body String email, String firstName, String lastName, String password);
}
