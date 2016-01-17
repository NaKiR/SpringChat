package com.nakir.chat.controller;

import com.nakir.chat.domain.Message;
import com.nakir.chat.domain.User;
import com.nakir.chat.service.MessageService;
import com.nakir.chat.service.UserService;
import com.nakir.chat.domain.ChatHistory;
import com.nakir.chat.util.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/loadChatHistoryAJAX.json", method=RequestMethod.GET)
    public @ResponseBody
    ChatHistory loadChatHistory() {
        StringBuilder chatHistory = messageService.fetchChatHistory();
        ChatHistory result = new ChatHistory(chatHistory.toString());
        return result;
    }

    @RequestMapping(value = "/postMessageAJAX.json", method=RequestMethod.POST)
    @Secured("ROLE_USER")
    public @ResponseBody
    void postChatMessage(@RequestParam(value="text") String text) {
        User user = getCurrentUser();
        if (user == null) {
            throw new ForbiddenException();
        }
        Message chatMessage = new Message(text, user);
        messageService.addMessage(chatMessage);
        return;
    }

    private User getCurrentUser() {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findUserByNick(currentUser);
    }
}

