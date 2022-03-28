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

import java.util.List;

public class ChatAdapter extends ArrayAdapter<Chat> {
    private int resLayout;
    private Context context;

    public ChatAdapter(@NonNull Context context, int resource, @NonNull List<Chat> objects) {
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

        Chat chat = getItem(position);

        if (chat != null){
            ImageView img = convertView.findViewById(R.id.chat_img);
            TextView name = convertView.findViewById(R.id.chat_name);
            TextView message = convertView.findViewById(R.id.chat_msg);

            img.setImageResource(chat.getImage());
            name.setText(chat.getTitle());

            if (chat.getMessage() != null || chat.getMessage() != ""){
                message.setText(chat.getMessage());
            }
        }

        return convertView;
    }
}
