package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.services.BlogService;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
public class BlogViewController {
    HttpSession httpSession;

    @Autowired
    BlogService blogService;

    @Autowired
    PostService postService;

    @GetMapping("/{blogName}")
    public String index(@PathVariable(value = "blogName") String blogName, Model model) {

        if(httpSession.getAttribute("user") != null) {
            Blog blog = blogService.findByNameEquals(blogName);
            httpSession.setAttribute("blog", blog); // Set the blog into the http session variable
            Set<Post> postList = postService.getAllByBlogIdEquals(blog.getId());
            model.addAttribute("postList", postList);
            // Create the view
            return "blogView/index";
        }

        return "redirect:/";
    }

    @GetMapping("/{blogName}/{category}")
    public String getPostByCategory(@PathVariable(value = "category") String category) {

        if(httpSession.getAttribute("user") != null) {
            Long l = 1L;
            Set<Post> categoryList = postService.getAllByCategoryEquals(l);
        }

        return "redirect:/";
    }

}
