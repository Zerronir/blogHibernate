package com.blog.controllers;

import com.blog.entities.User;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        User u = userService.findUserById(1L);
        return u.toString();
    }

    @GetMapping("/user/{email}")
    @ResponseBody
    public String userTest(@PathVariable(value = "email") String email) {
        User u = userService.findUserByEmail(email);
        return u.toString();
    }
}
