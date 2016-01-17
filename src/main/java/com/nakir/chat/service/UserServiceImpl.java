package com.nakir.chat.service;

import com.nakir.chat.dao.UserDao;
import com.nakir.chat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmailService emailService;

    public void addUser(User user) {
        saveUser(user, true);
        emailService.sendEmail(user.getEmail(), "Nick: " + user.getEmail() + "\nPassword: " + user.getPassword());
    }

    public User getUser(Long userId) {
        try {
            return userDao.getUser(userId);
        } catch (Exception ex) {
            return null;
        }
    }

    public void saveUser(User user) {
        saveUser(user, false);
    }

    public void saveUser(User user, boolean newUser) {
        if (user == null) {
            return;
        }

        try {
            User existingUser = userDao.findUserByNick(user.getNick());
            if ( existingUser == null ||
                    (!newUser && existingUser.getId().equals(user.getId()))) {
                user = userDao.save(user);
            }
        } catch (Exception ex) {
            return;
        }
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void deleteUser(Long userId) {
        try {
            User user = userDao.getUser(userId);
            if (user == null) {
                return;
            }
            userDao.delete(userId);
        } catch (Exception ex) {
            return;
        }
    }

    public User findUserByNick(String nick) {
        try {
            return userDao.findUserByNick(nick);
        } catch (Exception ex) {
            return null;
        }
    }
}
