package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String blogAdmin(@PathVariable(value = "blogName") String blogName) {

        if(httpSession.getAttribute("user") != null) {
            Blog blog = blogService.findByNameEquals(blogName);
            return "blogAdmin/index";
        }

        return "redirect:/";
    }
}
