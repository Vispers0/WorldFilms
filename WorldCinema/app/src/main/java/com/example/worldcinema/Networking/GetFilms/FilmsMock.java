package com.example.worldcinema.Networking.GetFilms;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.worldcinema.Fragments.test;
import com.example.worldcinema.Networking.API;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmsMock {

    ArrayList<Film> films;

    public FilmsMock(){
        films = new ArrayList<>();

        getFilmInfo();
    }

    public void getFilmInfo(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cinema.areas.su")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        API api = retrofit.create(API.class);

        Call<List<FilmsResponse>> call;
        call = api.getFilms();
        call.enqueue(new Callback<List<FilmsResponse>>() {
            @Override
            public void onResponse(Call<List<FilmsResponse>> call, Response<List<FilmsResponse>> response) {
                if (response.isSuccessful()){
                    for (int i = 0; i < response.body().size(); i++) {
                        films.add(new Film(response.body().get(i).getName(), response.body().get(i).getPoster()));
                    }

                    new FilmSetter(films);
                }
            }

            @Override
            public void onFailure(Call<List<FilmsResponse>> call, Throwable t) {

            }
        });

    }
}
