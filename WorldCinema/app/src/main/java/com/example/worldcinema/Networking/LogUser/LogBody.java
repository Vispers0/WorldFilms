package com.example.worldcinema.Networking.LogUser;

import com.google.gson.annotations.SerializedName;

public class LogBody {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public LogBody(String email, String password){
        this.email = email;
        this.password = password;
    }
}
