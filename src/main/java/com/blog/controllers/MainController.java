package com.blog.controllers;

import com.blog.entities.User;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;


@Controller
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/")
    @Transactional
    public ModelAndView index(Model model) {
        ModelAndView v = new ModelAndView();

        if(httpSession.getAttribute("user") != null) {
            User u = (User) httpSession.getAttribute("user");
            model.addAttribute("userName", u.getName() + " " + u.getLastname());
            v.setViewName("index");
        } else {
            v.setViewName("login");
        }

        return v;
    }
}
