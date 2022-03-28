package com.example.worldcinema;

import android.net.Uri;

public class Chat {
    private String title;
    private int image;
    private String message;

    public Chat(String title, int image, String message){
        this.title = title;
        this.image = image;
        this.message = message;
    }

    public Chat(String title, int image){
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public String getMessage() {
        return message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
