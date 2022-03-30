package com.example.worldcinema.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldcinema.R;

import org.w3c.dom.Text;

import java.net.URI;
import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {

    private ArrayList<Film> filmList;
    private Context mContext;

    public FilmAdapter(ArrayList<Film> filmList, Context context){
        this.filmList = filmList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public FilmAdapter.FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.film_cover_item, parent, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.FilmHolder holder, int position) {
        final Film film = filmList.get(position);

        holder.setFilmTitle(film.getTitle());
        holder.setFilmCover(film.getCover());
    }

    @Override
    public int getItemCount() {
        return filmList == null? 0: filmList.size();
    }

    public class FilmHolder extends RecyclerView.ViewHolder{

        private TextView filmTitle;
        private ImageView filmCover;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);

            filmTitle = itemView.findViewById(R.id.txtTitle);
            filmCover = itemView.findViewById(R.id.imgCover);
        }

        public void setFilmTitle(String title){
            filmTitle.setText(title);
        }

        public void setFilmCover(Bitmap resId){
            filmCover.setImageBitmap(resId);
        }
    }
}
