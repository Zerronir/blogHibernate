package com.blog.controllers;

import com.blog.entities.User;
import com.blog.services.UserService;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/doLogin")
    public String doLoginGet() {
        return "redirect:";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String email, @RequestParam String password) {

        if (httpSession.getAttribute("user") != null) {
            return "redirect:";
        } else {
            try {

                if (!email.equals("") && !password.equals("")) {
                    User u = userService.findUserByEmail(email);
                    if(!u.getEmail().isEmpty()){
                        httpSession.setAttribute("user", u);
                        return "redirect:/";
                    } else {
                        return "redirect:login";
                    }
                }

            } catch (QueryException e) {
                return "redirect:login";
            }
        }

        return "redirect:login";
    }

    @GetMapping("/doLogout")
    public String logoutUser () {
        httpSession.invalidate();
        return "redirect:/";
    }

}
