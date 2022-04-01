package com.example.watch;

import com.google.gson.annotations.SerializedName;

//Модель ответа сервера по запросу авторизации
public class LoginResponse {
    @SerializedName("token")
    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
