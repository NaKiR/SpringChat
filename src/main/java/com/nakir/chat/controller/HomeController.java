package com.nakir.chat.controller;

import com.nakir.chat.domain.User;
import com.nakir.chat.service.MessageService;
import com.nakir.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = {"/"}, method= RequestMethod.GET)
    public String index(Map<String, Object> model) {
        StringBuilder chatHistory = messageService.fetchChatHistory();
        User user = getCurrentUser();

        model.put("page", "home");
        model.put("authenticated", user != null);
        model.put("user", user);
        model.put("chatHistory", chatHistory.toString());
        return "home";
    }

    private User getCurrentUser() {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findUserByNick(currentUser);
    }
}

