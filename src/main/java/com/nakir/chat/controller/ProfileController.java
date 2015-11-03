package com.nakir.chat.controller;

import com.nakir.chat.domain.User;
import com.nakir.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value="/profile/view/{id}", method=RequestMethod.GET)
//    public String viewProfile(@PathVariable("id") long id,
//                           ModelMap model) {
////        }
//        User user = userService.getUser(id);
//        if (user == null) {
//            throw new RuntimeException();
//        }
//        model.put("user", user);
//        model.put("page", "profile");
//        return "profile/viewProfile";
//    }

    @RequestMapping(value="/profile/new", method=RequestMethod.GET)
    public String showRegistrationForm(Map<String, Object> model) {
        model.put("user", new User());
        model.put("page", "register");
        return "profile/createProfile";
    }

    @RequestMapping(value="/profile/new", method=RequestMethod.POST)
    public String addUserFromForm(User user,
                                  BindingResult bindingResult) {
        return createOrUpdateUser(user, bindingResult, true);
    }

//    @RequestMapping(value="/profile/edit/{id}", method=RequestMethod.POST)
//    public String saveUserProfile(@Valid User user,
//                                  BindingResult bindingResult) {
//        return createOrUpdateUser(user, bindingResult, false);
//    }

//    @RequestMapping(value="/profile/edit/{id}", method=RequestMethod.GET)
//    public String editUserProfile(@PathVariable("id") long id,
//                                  ModelMap model) {
//        User requestedUser = userService.getUser(id);
//        if (requestedUser == null) {
//            throw new RuntimeException();
//        }
//        User currentUser = getCurrentUser();
//        if (!currentUser.getId().equals(requestedUser.getId())) {
//            throw new RuntimeException();
//        }
//        model.put("user", requestedUser);
//        model.put("page", "profile");
//        return "profile/editProfile";
//    }

    private String createOrUpdateUser(User user,
                                      BindingResult bindingResult,
                                      Boolean create) {
        String viewName = create ? "profile/createProfile" : "profile/editProfile";

        if(bindingResult.hasErrors()) {
            return viewName;
        }

        Boolean changedNickName  = false;
        if (create) {
            userService.addUser(user);
        } else {
            User existingUser = userService.getUser(user.getId());
            existingUser.setNick(user.getNick());
            existingUser.setPassword(user.getPassword());
            userService.saveUser(existingUser);
        }

        user = userService.findUserByNick(user.getNick());

        if (create) {
            return "redirect:/login";
        } else {
            return "redirect:/profile/view/" + user.getId();
        }
    }

    private User getCurrentUser() {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findUserByNick(currentUser);
    }
}
