package com.example.worldcinema.Networking.LogUser;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Trace;
import android.widget.Toast;

import com.example.worldcinema.MainActivity;
import com.example.worldcinema.MainScreen;
import com.example.worldcinema.Networking.API;
import com.example.worldcinema.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogMock {
    private String email;
    private String password;

    private Context context;

    public LogMock(String email, String password, Context context){
        this.email = email;
        this.password = password;
        this.context = context;

        log_user();
    }

    public void log_user(){
        LogBody logBody = new LogBody(email, password);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cinema.areas.su")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        API api = retrofit.create(API.class);

        AsyncTask.execute(()->{
            Call<LogResponse> call;
            call = api.logUser(logBody);
            call.enqueue(new Callback<LogResponse>() {
                @Override
                public void onResponse(Call<LogResponse> call, Response<LogResponse> response) {
                    if (response.isSuccessful()){
                        context.startActivity(new Intent(context, MainScreen.class));
                        int token = response.body().get_token();
                        Toast.makeText(context, "Successful. Your token is: " + token, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LogResponse> call, Throwable t) {
                    Toast.makeText(context, "Response Error", Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });
        });
    }
}
