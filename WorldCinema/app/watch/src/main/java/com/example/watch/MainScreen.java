package com.example.watch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.watch.databinding.ActivityMainScreenBinding;

public class MainScreen extends Activity {

    private ActivityMainScreenBinding binding;
    private ImageView btn_films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btn_films = findViewById(R.id.btn_films);
        btn_films.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, Films.class));
            }
        });
    }
}