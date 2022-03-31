package com.example.worldcinema.Networking.GetFilms;

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
    @SerializedName("images")
    private String images;
    @SerializedName("poster")
    private String poster;
    @SerializedName("tags")
    private String tags;
    @SerializedName("idTags")
    private String idTags;
    @SerializedName("tagName")
    private String tagName;

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

    public String getImages() {
        return images;
    }

    public String getPoster() {
        return poster;
    }

    public String getTags() {
        return tags;
    }

    public String getIdTags() {
        return idTags;
    }

    public String getTagName() {
        return tagName;
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

    public void setImages(String images) {
        this.images = images;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setIdTags(String idTags) {
        this.idTags = idTags;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
