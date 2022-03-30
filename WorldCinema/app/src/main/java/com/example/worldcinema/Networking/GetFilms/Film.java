package com.example.worldcinema.Networking.GetFilms;

import android.graphics.Bitmap;

public class Film {
    private String title;
    private Bitmap cover;

    public Film (String title, Bitmap cover){
        this.title = title;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public Bitmap getCover() {
        return cover;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover(Bitmap cover) {
        this.cover = cover;
    }
}
