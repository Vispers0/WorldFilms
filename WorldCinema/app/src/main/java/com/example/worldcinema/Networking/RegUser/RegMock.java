package com.example.worldcinema.Networking.RegUser;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.worldcinema.register;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegMock {

    private String email, firstname, lastname, password;
    private Context context;

    public RegMock(String email, String firstname, String lastname, String password, Context context){
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.context = context;

        register_user();
    }

    public void register_user(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cinema.areas.su")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        RegBody body = new RegBody();
        body.email = email;
        body.firstname = firstname;
        body.lastname = lastname;
        body.password = password;



        Call<Void> call;
        call = api.regUser(body);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }



}
