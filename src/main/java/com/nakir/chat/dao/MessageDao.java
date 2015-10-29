package com.nakir.chat.dao;

import com.nakir.chat.domain.Message;

import java.util.List;

public interface MessageDao {
    public Message getMessage(Long messageId);
    public void addMessage(Message message);
    public List<Message> getRecentMessages();
}
