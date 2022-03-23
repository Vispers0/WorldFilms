package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getSupportActionBar().hide();

        setMainFragment();
    }

    public void setMainFragment(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        new_films_fragment fragment = new_films_fragment.newInstance();
        ft.replace(R.id.fragment_dummy, fragment);
        ft.commit();
    }

}