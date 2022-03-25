package com.example.worldcinema.Networking.LogUser;

import com.google.gson.annotations.SerializedName;

public class LogResponse {
    @SerializedName("token")
    private int token;

    public int get_token(){
        return token;
    }
}
