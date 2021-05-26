package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.Post;
import com.blog.services.BlogService;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Set;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    PostService postService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/admin/{blogName}")
    public String blogAdmin(@PathVariable(value = "blogName") String blogName, Model model) {

        if(httpSession.getAttribute("user") != null) {
            String name = blogName.replace("-", " ");
            Blog blog = blogService.findByNameEquals(name);
            model.addAttribute("blog", blog);
            return "adminBlog/index";
        }

        return "redirect:/";
    }

    @GetMapping("/admin/{blogName}/postList")
    public String postList(@PathVariable(value = "blogName") String blogName, Model model) {

        if(httpSession.getAttribute("user") != null) {
            String name = blogName.replace("-", " ");
            Blog blog = blogService.findByNameEquals(name);
            Set<Post> postList = postService.getAllByBlogIdEquals(blog.getId());
            int postCount = postList.size();
            model.addAttribute("blog", blog);
            model.addAttribute("postList", postList);
            model.addAttribute("postCount", postCount);
            return "adminBlog/postList";
        }

        return "redirect:/";
    }

}
