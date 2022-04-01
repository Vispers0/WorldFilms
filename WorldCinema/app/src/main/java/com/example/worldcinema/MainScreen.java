package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.worldcinema.Fragments.new_films_fragment;
import com.example.worldcinema.Fragments.profile;
import com.example.worldcinema.Networking.GetChats.ChatMock;

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
        new_films_fragment fragment = new_films_fragment.newInstance(MainScreen.this);
        ft.replace(R.id.fragment_dummy, fragment);
        ft.commit();
    }

    public void setMainFragmentClick(MenuItem item){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        new_films_fragment fragment = new_films_fragment.newInstance(MainScreen.this);
        ft.replace(R.id.fragment_dummy, fragment);
        ft.commit();
    }

    public void setProfileFragment(MenuItem item){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        profile fragment = profile.newInstance();
        ft.replace(R.id.fragment_dummy, fragment);
        ft.commit();
    }

    public void chatsClick(View v){
        new ChatMock(MainScreen.this);
    }
}