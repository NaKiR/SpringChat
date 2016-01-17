package com.nakir.chat.service;

import com.nakir.chat.domain.Message;

public interface MessageService {
    public Message getMessage(Long messageId);
    public void addMessage(Message message);
    public StringBuilder fetchChatHistory();
}
