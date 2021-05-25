package com.blog.controllers;

import com.blog.entities.User;
import com.blog.services.UserService;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

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
                    String hash = userService.encryptedPassword(password);

                    if(!u.getEmail().isEmpty() && u.getPassword().equals(hash)){
                        httpSession.setAttribute("user", u);
                        return "redirect:/";
                    } else {
                        return "redirect:login";
                    }
                }

            } catch (QueryException | NoSuchAlgorithmException e) {
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

    @GetMapping("/register")
    public String registerPage() {
        if(httpSession.getAttribute("user") == null) {
            return "register";
        }
        return "redirect:/";
    }

    @PostMapping("/doRegister")
    public String doRegister(@RequestParam String name,@RequestParam String nickname, @RequestParam String email, @RequestParam String lastname,@RequestParam String password, @RequestParam String password1) {
        if(httpSession.getAttribute("user") == null) {
            try {

                if(!email.equals("") && !password.equals("") && !password1.equals("") && password.equals(password1)) {
                    User u = new User();
                    String hashedPass = userService.encryptedPassword(password);
                    u.setName(name);
                    u.setNickname(nickname);
                    u.setLastname(lastname);
                    u.setEmail(email);
                    u.setPassword(hashedPass);
                    u.setCreated_at(LocalDate.now());
                    u.setUpdated_at(LocalDate.now());

                    userService.save(u);

                    httpSession.setAttribute("user", u);
                    return "redirect:/";
                }

            }catch (QueryException | NoSuchAlgorithmException ex) {
                return "redirect:register";
            }
        }
        return "redirect:/";
    }

}
