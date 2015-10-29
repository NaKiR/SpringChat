package com.nakir.chat.controller;

import com.nakir.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = {"/"}, method= RequestMethod.GET)
    public String index(Map<String, Object> model) {
        StringBuilder chatHistory = messageService.fetchChatHistory();
        model.put("chatHistory", chatHistory.toString());
        return "home";
    }

    @RequestMapping(value="/reg", method=RequestMethod.GET)
    public String register() {
        return "redirect:/";
    }
}

