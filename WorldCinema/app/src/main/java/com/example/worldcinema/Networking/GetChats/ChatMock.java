package com.example.worldcinema.Networking.GetChats;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.worldcinema.Chat;
import com.example.worldcinema.ChatAdapter;
import com.example.worldcinema.Chats;
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

public class ChatMock {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private static final String APP_PREFERENCES = "Prefs";
    private static final String APP_PREFERENCES_TOKEN = "Token";

    public String token;

    public ArrayList<ChatInfo> chats;

    Context context;

    Intent intent;

    public ChatMock(Context context, Intent intent){
        getChats();

        this.context = context;
        this.intent = intent;

        preferences = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);

        token = preferences.getString(APP_PREFERENCES_TOKEN, "");
        editor = preferences.edit();

        chats = new ArrayList<>();
    }

    public void getChats(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://cinema.areas.su")
                .client(client.build())
                .build();

        API api = retrofit.create(API.class);

        Call<List<ChatResponse>> call;
        call = api.getUserChats(token);
        call.enqueue(new Callback<List<ChatResponse>>() {
            @Override
            public void onResponse(Call<List<ChatResponse>> call, Response<List<ChatResponse>> response) {
                if (response.isSuccessful()){
                    for (int i = 0; i < response.body().size() - 1; i++){
                        chats.add(new ChatInfo(response.body().get(i).getChatID(), response.body().get(i).getChatName()));
                        Intent intent = new Intent(context, Chats.class);
                        intent.putExtra("chats", chats);
                        context.startActivity(intent);
                    }
                }
                else {
                    Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ChatResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
