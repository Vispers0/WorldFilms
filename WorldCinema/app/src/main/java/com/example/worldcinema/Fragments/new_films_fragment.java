package com.example.worldcinema.Fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldcinema.Networking.API;
import com.example.worldcinema.Networking.GetFilms.FilmsResponse;
import com.example.worldcinema.R;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class new_films_fragment extends Fragment {

    private static Context context;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RecyclerView recycler;

    public FilmAdapter adapter;

    public new_films_fragment() {

    }

    //Создание фрагмента
    public static new_films_fragment newInstance(Context mcontext) {
        context = mcontext;
        return new new_films_fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //Получение разметки для фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_films_fragment, container, false);
    }

    //Заполнение RecyclerView фильмами
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        recycler = view.findViewById(R.id.recycle);

        getFilms();

        PagerSnapHelper helper = new PagerSnapHelper();
        LinearLayoutManager manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        helper.attachToRecyclerView(recycler);
        recycler.setLayoutManager(manager);
    }

    //Парсинг фильмов
    public void getFilms(){
        ///Interceptor и Client для вывода логов при работе в сети
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        //Retrofit - библиотека, с помощью которой ведётся работа с сервером
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cinema.areas.su")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        API api = retrofit.create(API.class);

        //Получение списка новых фильмов
        Call<ArrayList<FilmsResponse>> call;
        call = api.getFilms();
        AsyncTask.execute(()->{
            call.enqueue(new Callback<ArrayList<FilmsResponse>>() {
                @Override
                public void onResponse(Call<ArrayList<FilmsResponse>> call, Response<ArrayList<FilmsResponse>> response) {
                    if (response.isSuccessful()){
                        ArrayList<FilmsResponse> films = new ArrayList<>();
                        films = response.body();

                        FilmAdapter adapter = new FilmAdapter(films, getContext());

                        recycler.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<FilmsResponse>> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });

    }
}