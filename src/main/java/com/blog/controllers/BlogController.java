package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/{blogName}")
    public String blogAdmin(@PathVariable(value = "blogName") String blogName, Model model) {

        if(httpSession.getAttribute("user") != null) {
            String name = blogName.replace("-", " ");
            Blog blog = blogService.findByNameEquals(name);
            model.addAttribute("blog", blog);
            return "blogAdmin/index";
        }

        return "redirect:/";
    }
}
