package com.example.worldcinema.Networking.RegUser;

import android.widget.Toast;

import com.example.worldcinema.register;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegMock {

    private String email, firstname, lastname, password;

    public RegMock(String email, String firstname, String lastname, String password){
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://cinema.areas.su/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Server server1 = retrofit.create(Server.class);
    Call<List<RegModel>> call = server1.regUser(email, firstname, lastname, password).enqueue(new Callback<List<RegModel>>() {
        @Override
        public void onResponse(Call<List<RegModel>> call, Response<List<RegModel>> response) {
            if (response.isSuccessful()){
                Toast.makeText(register.this, "Success", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<List<RegModel>> call, Throwable t) {

        }
    });
}
