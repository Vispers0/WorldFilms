package com.example.worldcinema.Networking.GetFilms;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.worldcinema.Fragments.test;
import com.example.worldcinema.Networking.API;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmsMock {

    ArrayList<test> arrayList;

    public FilmsMock(){
        arrayList = new ArrayList<>();
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

        AsyncTask.execute(()->{
            Call<FilmsResponse> call;
            call = api.getFilms();
            call.enqueue(new Callback<FilmsResponse>() {
                @Override
                public void onResponse(Call<FilmsResponse> call, Response<FilmsResponse> response) {
                    if (response.isSuccessful())
                        Log.i("RESPONSE_FILMS", response.body().getName() + " - " + response.body().getPoster());
                }

                @Override
                public void onFailure(Call<FilmsResponse> call, Throwable t) {

                }
            });
        });

    }
}
