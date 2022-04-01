package com.example.watch;

import com.google.gson.annotations.SerializedName;

public class FilmsResponse {
    @SerializedName("movieId")
    private String movieId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("age")
    private String age;
    @SerializedName("poster")
    private String poster;


    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAge() {
        return age;
    }



    public String getPoster() {
        return poster;
    }



    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public void setPoster(String poster) {
        this.poster = poster;
    }

}
