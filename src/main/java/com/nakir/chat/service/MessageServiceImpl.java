package com.nakir.chat.service;

import com.nakir.chat.dao.MessageDao;
import com.nakir.chat.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public Message getMessage(Long messageId) {
        return messageDao.getMessage(messageId);
    }

    public List<Message> getRecentMessages() {
        List<Message> list = messageDao.getRecentMessages();
        Collections.reverse(list);
        return list;
    }

    public void addMessage(Message message) {
        messageDao.addMessage(message);
    }

    public StringBuilder fetchChatHistory() {
        StringBuilder chatHistory = new StringBuilder();
        List<Message> messages = getRecentMessages();

        for (Message m : messages ) {
            chatHistory.append(String.format("<a href=\"/profile/view/%s\"><b>%s</b></a>: %s<br />",
                    m.getAuthor().getId(),
                    m.getAuthor().getNick(),
                    m.getMessage()));
        }
        return chatHistory;
    }
}

