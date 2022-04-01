package com.example.worldcinema.Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldcinema.Networking.GetFilms.FilmsResponse;
import com.example.worldcinema.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {

    private ArrayList<FilmsResponse> responses;
    private Context context;

    public FilmAdapter(ArrayList<FilmsResponse> responses, Context context){
        this.context = context;
        this.responses = responses;
    }

    @Override
    public FilmHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.film_cover_item, parent, false);

        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {
        final FilmsResponse response = responses.get(position);

        holder.setTitle(response.getName());
        holder.setCover(response.getPoster());
    }

    @Override
    public int getItemCount() {
        return responses == null? 0: responses.size();
    }

    public class FilmHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView cover;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitle);
            cover = itemView.findViewById(R.id.imgCover);

        }

        public void setTitle(String title){
            this.title.setText(title);
        }

        public void setCover(String cover) {
            Picasso.with(context).load("http://cinema.areas.su/up/images/" + cover).into(this.cover);
        }
    }
}
