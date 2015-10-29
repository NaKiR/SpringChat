package com.nakir.chat.dao;

import com.nakir.chat.domain.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public User getUser(Long userId) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
        return user;
    }

    @Transactional
    public User save(User user) {
        user = (User) sessionFactory.getCurrentSession().merge(user);
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        return user;
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> userList = sessionFactory.getCurrentSession().createQuery("from User").list();
        return userList;
    }

    @Transactional
    public void delete(Long userId) {
        User user = getUser(userId);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Transactional
    public User findUserByNick(String nick) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.nick = :nick");
        query.setString("nick", nick);
        User user = null;
        List list = query.list();
        if (list.size() > 0) {
            user = (User) list.get(0);
        }
        return user;
    }
}

