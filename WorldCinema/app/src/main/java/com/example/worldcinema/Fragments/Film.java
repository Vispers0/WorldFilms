package com.example.worldcinema.Fragments;

public class Film {
    private String title;
    private int cover;

    public Film(String title , int cover){
        this.title = title;
        this.cover = cover;
    }

    public String getTitle(){
        return title;
    }

    public int getCover(){
        return cover;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCover(int cover){
        this.cover = cover;
    }
}
