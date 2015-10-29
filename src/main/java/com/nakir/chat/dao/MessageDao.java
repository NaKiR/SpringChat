package com.nakir.chat.dao;


import com.nakir.chat.domain.Message;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("messageDao")
//@Transactional(value="transactionManager")
public class MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Message getMessage(Long messageId) {
        Message message = (Message) sessionFactory.getCurrentSession().get(Message.class, messageId);
        return message;
    }

    @Transactional
    public void addMessage(Message message) {
        sessionFactory.getCurrentSession().save(message);
    }

    @Transactional
    public List<Message> getRecentMessages() {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("fetchRecentMessages");
            List<Message> list = query.list();
            return list.subList(0, list.size());
    }
}
