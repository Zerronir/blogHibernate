package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.User;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
public class AdminPageController {
    @Autowired
    BlogService blogService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/posts")
    public String showPosts() {
        if(httpSession.getAttribute("user") != null) {
            return "postList";
        }
        return "redirect:/";
    }

    @GetMapping("/blogList")
    public String blogList(Model model) {
        if(httpSession.getAttribute("user") != null) {
            User u = (User) httpSession.getAttribute("user");
            // Tornam un comptador de blogs i una llista de blogs de l'usuari
            Set<Blog> blogs = blogService.getAllByUserSetIdEquals(u.getId());
            int counter = blogService.getAllByUserSetIdEquals(u.getId()).size();
            model.addAttribute("blogList", blogs);
            model.addAttribute("blogCounter", counter);

            // Carregam el JSP
            return "blogList";
        }

        return "redirect:/";
    }

}
