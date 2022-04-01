package com.example.watch;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.watch.databinding.ActivityFilmsBinding;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Films extends Activity {

    private ActivityFilmsBinding binding;

    private List<FilmsResponse> films;
    private FilmsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFilmsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getFilms();
    }

    //Парсинг фильмов
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

        Call<List<FilmsResponse>> call;
        call = api.get_films();

        AsyncTask.execute(()->{
            call.enqueue(new Callback<List<FilmsResponse>>() {
                @Override
                public void onResponse(Call<List<FilmsResponse>> call, Response<List<FilmsResponse>> response) {
                    if (response.isSuccessful()){
                        ListView lv = findViewById(R.id.films_lv);

                        films = response.body();

                        FilmsAdapter adapter1 = new FilmsAdapter(Films.this, R.layout.film_list_item, films);
                        Log.i("XYI", films.get(0).getName());
                        lv.setAdapter(adapter1);
                    }
                    else{
                        Log.i("XYI", String.valueOf(response.code()));
                    }
                }

                @Override
                public void onFailure(Call<List<FilmsResponse>> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });
    }
}