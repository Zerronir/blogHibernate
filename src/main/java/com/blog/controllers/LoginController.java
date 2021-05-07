package com.blog.controllers;

import com.blog.entities.User;
import com.blog.services.UserService;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    HttpSession httpSession;

    @PostMapping("/doLogin")
    public String doLogin(@RequestBody String email, @RequestBody String password) {

        if (httpSession.getAttribute("user") != null) {
            return "redirect:index";
        } else {
            try {

                if (!email.equals("") && !password.equals("")) {
                    User u = userService.findUserByEmail(email);
                    if(!u.getEmail().isEmpty()){
                        httpSession.setAttribute("user", u);
                        return "redirect:users";
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

}
