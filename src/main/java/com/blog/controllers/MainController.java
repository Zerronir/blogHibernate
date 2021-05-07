package com.blog.controllers;

import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView v = new ModelAndView();
        v.setViewName("login");
        return v;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Hola!!!";
    }



}
