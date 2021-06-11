package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.UserComments;
import com.blog.entities.Post;
import com.blog.services.BlogService;
import com.blog.services.CommentService;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
public class PostController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    PostService postService;

    @Autowired
    BlogService blogService;

    @GetMapping("/admin/{blogSlug}/{postSlug}")
    public String viewPost(@PathVariable(value = "blogSlug") String blog, @PathVariable(value = "postSlug") String post) {

        if(httpSession.getAttribute("user") != null) {

            return "adminBlog/post";
        }

        return "redirect:/";
    }
}
