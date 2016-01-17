package com.nakir.chat.domain;

public class ChatHistory {
    private String data;

    public ChatHistory(String chatHistory) {
        data = chatHistory;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
