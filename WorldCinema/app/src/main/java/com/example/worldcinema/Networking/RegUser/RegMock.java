package com.example.worldcinema.Networking.RegUser;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.worldcinema.Networking.API;
import com.example.worldcinema.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegMock {

    private String email, firstname, lastname, password;
    private Context context;
    private String BASE_URL = String.valueOf(R.string.BASE_URL);

    public RegMock(String email, String firstname, String lastname, String password, Context context){
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.context = context;

        register_user();
    }

    //Регистрация пользователя
    public void register_user(){
        ///Interceptor и Client для вывода логов при работе в сети
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        //Retrofit - библиотека, с помощью которой ведётся работа с сервером
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cinema.areas.su")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        API api = retrofit.create(API.class);

        //RegBody содержит тело запроса
        RegBody body = new RegBody();
        body.email = email;
        body.firstname = firstname;
        body.lastname = lastname;
        body.password = password;

        //Регистрация пользователя
        AsyncTask.execute(()->{
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
        });
    }



}
