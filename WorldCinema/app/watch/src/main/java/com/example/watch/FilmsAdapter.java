package com.example.watch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends BaseAdapter {
    private Context context;
    private int resId;
    private List<FilmsResponse> films;
    private LayoutInflater inflater;

    public FilmsAdapter(@NonNull Context context, int resource, @NonNull List<FilmsResponse> objects) {
        this.context = context;
        this.films = objects;
        this.resId = resource;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public FilmsResponse getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;

        if (v == null){
            LayoutInflater li = LayoutInflater.from(context);
            v = inflater.inflate(resId, parent, false);
        }

        FilmsResponse response = getItem(position);

        TextView txtTitle = v.findViewById(R.id.txt_film_title);
        ImageView cover = v.findViewById(R.id.img_cover);


        txtTitle.setText(response.getName());

        Picasso.with(context).load("http://cinema.areas.su/up/images/" + response.getPoster()).into(cover);


        return v;
    }
}
