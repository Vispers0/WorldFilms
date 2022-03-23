package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    public void register_click(View view){
        startActivity(new Intent(MainActivity.this, com.example.worldcinema.register.class));
    }

    public void login_click(View view){
        startActivity(new Intent(MainActivity.this, MainScreen.class));
    }
}