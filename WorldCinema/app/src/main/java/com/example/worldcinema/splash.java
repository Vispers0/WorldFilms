package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        Thread timer = new Thread(){
            public void run(){
                try {
                    int time = 0;
                    while (time < 2000){
                        sleep(1000);
                        time += 1000;
                    }
                    startActivity(new Intent(splash.this, MainActivity.class));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };
        timer.start();
    }
}