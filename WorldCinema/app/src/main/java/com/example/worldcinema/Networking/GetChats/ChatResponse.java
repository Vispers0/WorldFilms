package com.example.worldcinema.Networking.GetChats;

import com.google.gson.annotations.SerializedName;

//Модель ответа сервера по запросу чатов
public class ChatResponse {
    @SerializedName("chatId")
    private String chatID;
    @SerializedName("name")
    private String chatName;

    public ChatResponse(String chatID, String chatName){
        this.chatID = chatID;
        this.chatName = chatName;
    }

    public String getChatID() {
        return chatID;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
}
