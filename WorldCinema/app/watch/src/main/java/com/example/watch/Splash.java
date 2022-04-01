package com.example.watch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.watch.databinding.ActivitySplashBinding;

import java.util.Timer;

public class Splash extends Activity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Загрузочный экран на 2 секунды
        Thread timer = new Thread(){
            public void run(){
                try {
                    int time = 0;
                    while (time < 2000){
                        sleep(1000);
                        time += 1000;
                    }
                    startActivity(new Intent(Splash.this, LogIn.class));
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