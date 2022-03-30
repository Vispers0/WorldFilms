package com.example.worldcinema;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.worldcinema.Networking.GetChats.ChatInfo;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<ChatInfo> {
    private int resLayout;
    private Context context;

    public ChatAdapter(@NonNull Context context, int resource, @NonNull List<ChatInfo> objects) {
        super(context, resource, objects);

        this.resLayout = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView == null){
            LayoutInflater li  = LayoutInflater.from(context);
            convertView = li.inflate(resLayout, null);
        }

        ChatInfo chat = getItem(position);

        if (chat != null){
            ImageView img = convertView.findViewById(R.id.chat_img);
            TextView name = convertView.findViewById(R.id.chat_name);
            TextView message = convertView.findViewById(R.id.chat_msg);

            name.setText(chat.getChatName());
        }

        return convertView;
    }
}
