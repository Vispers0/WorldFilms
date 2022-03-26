package com.example.worldcinema.Fragments;

public class test {
    private String title;
    private String img;

    public test(String name, String poster){
        this.title = name;
        this.img = poster;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
