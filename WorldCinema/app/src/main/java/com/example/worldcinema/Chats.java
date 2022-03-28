package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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

        chats.add(new Chat("Name 1", R.drawable.chat_template, "FUCK YOU"));
        chats.add(new Chat("Name 2", R.drawable.chat_template));
        chats.add(new Chat("Name 3", R.drawable.chat_template));
        chats.add(new Chat("Name 4", R.drawable.chat_template, "300 BUCKS"));
        chats.add(new Chat("Name 5", R.drawable.chat_template));
        chats.add(new Chat("Name 6", R.drawable.chat_template, "LOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOLOL"));

        adapter = new ChatAdapter(Chats.this, R.layout.chats_list_item, chats);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
    }
}