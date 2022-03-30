package com.example.worldcinema.Networking.GetChats;

import java.io.Serializable;

public class ChatInfo implements Serializable {
    private String chatID;
    private String chatName;

    public ChatInfo(String chatID, String chatName){
        this.chatID = chatID;
        this.chatName = chatName;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getChatID() {
        return chatID;
    }

    public String getChatName() {
        return chatName;
    }
}
