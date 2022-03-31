package com.example.worldcinema.Networking.GetFilms;

import android.content.Context;
import android.os.AsyncTask;

import com.example.worldcinema.Fragments.FilmAdapter;
import com.example.worldcinema.Fragments.new_films_fragment;
import com.example.worldcinema.Networking.API;
import com.example.worldcinema.R;

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

    private Context context;

    public FilmsMock(Context context){
        this.context = context;
    }

    public void getFilms(){
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

        Call<ArrayList<FilmsResponse>> call;
        call = api.getFilms();
        AsyncTask.execute(()->{
            call.enqueue(new Callback<ArrayList<FilmsResponse>>() {
                @Override
                public void onResponse(Call<ArrayList<FilmsResponse>> call, Response<ArrayList<FilmsResponse>> response) {
                    if (response.isSuccessful()){
                        ArrayList<FilmsResponse> films = new ArrayList<>();
                        films = response.body();
                        new_films_fragment nff = new new_films_fragment();
                        nff.adapter = new FilmAdapter(films, context);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<FilmsResponse>> call, Throwable t) {

                }
            });
        });

    }
}
