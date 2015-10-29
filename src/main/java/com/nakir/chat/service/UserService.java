package com.nakir.chat.service;

import com.nakir.chat.domain.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public User getUser(Long userId);
    public void saveUser(User user);
    public void saveUser(User user, boolean newUser);
    public List<User> getAllUsers();
    public void deleteUser(Long userId);
    public User findUserByNick(String nick);
}
