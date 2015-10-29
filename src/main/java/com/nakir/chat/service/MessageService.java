package com.nakir.chat.service;

import com.nakir.chat.domain.Message;

import java.util.List;

public interface MessageService {
    public Message getMessage(Long messageId);
    public List<Message> getRecentMessages();
    public void addMessage(Message message);
    public StringBuilder fetchChatHistory();
}
