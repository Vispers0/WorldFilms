package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.worldcinema.Networking.GetChats.ChatMock;

import java.io.File;
import java.util.ArrayList;

public class Chats extends AppCompatActivity {

    ListView listView;

    ArrayList<Chat> chats;
    ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        getSupportActionBar().hide();

        listView = findViewById(R.id.chats_lv);
        chats = new ArrayList<>();

        chats = (ArrayList<Chat>) new Intent().getExtras().get("chats");

        adapter = new ChatAdapter(Chats.this, R.layout.chats_list_item, chats);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }
}