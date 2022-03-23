package com.example.worldcinema.Networking.RegUser;

import com.google.gson.annotations.SerializedName;

public class RegModel {
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("firstName")
    public String firstName;
    @SerializedName("lastName")
    public String lastName;
}
