package com.example.worldcinema.Networking.GetFilms;

import com.google.gson.annotations.SerializedName;

public class FilmsResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("poster")
    private String poster;

    public String getName() {
        return name;
    }

    public String getPoster() {
        return poster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
