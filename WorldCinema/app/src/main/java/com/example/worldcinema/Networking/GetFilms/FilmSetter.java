package com.example.worldcinema.Networking.GetFilms;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;

import com.example.worldcinema.Fragments.test;
import com.example.worldcinema.Networking.API;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmSetter {

    public ArrayList<Film> films;
    public ArrayList<Bitmap> covers;

    private final String BASE_URL = "http://cinema.areas.su/up/images/";

    public FilmSetter(ArrayList<Film> films){
        this.films = films;
    }

    public FilmSetter(){

    }

    public ArrayList<Bitmap> getCovers(){
        for (int i = 0; i<films.size(); i++){
            try{
                URL url = new URL(BASE_URL + films.get(i).getCover());
                Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                covers.add(image);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

        return covers;
    }

    public ArrayList<String> getTitles(){
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < films.size(); i ++){
            titles.add(films.get(i).getTitle());
        }

        return titles;
    }
}
