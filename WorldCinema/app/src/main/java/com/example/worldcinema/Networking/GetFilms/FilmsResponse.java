package com.example.worldcinema.Networking.GetFilms;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class FilmsResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("poster")
    private Bitmap poster;

    public String getName() {
        return name;
    }

    public Bitmap getPoster() {
        return poster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoster(Bitmap poster) {
        this.poster = poster;
    }
}
