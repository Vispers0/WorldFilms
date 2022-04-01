package com.example.worldcinema.Networking.RegUser;

import com.google.gson.annotations.SerializedName;

//Тело запроса на сервер
public class RegBody {
    @SerializedName("email")
    public String email;
    @SerializedName("firstName")
    public String firstname;
    @SerializedName("lastName")
    public String lastname;
    @SerializedName("password")
    public String password;
}
