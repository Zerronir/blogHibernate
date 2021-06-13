package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.User;
import com.blog.services.BlogService;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Set;

@Controller
public class AdminPageController {
    @Autowired
    BlogService blogService;

    @Autowired
    HttpSession httpSession;



    static LocalDate localDate;

    @GetMapping("/posts")
    public String showPosts() {
        if(httpSession.getAttribute("user") != null) {
            return "adminPanel/postList";
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
            return "adminPanel/blogList";
        }

        return "redirect:/";
    }

    @GetMapping("/createBlog")
    public String createBlogGet(){
        if(httpSession.getAttribute("user") != null) {
            return "adminPanel/createBlog";
        }
        return "redirect:/";
    }

    @PostMapping("/createBlog")
    public String createBlogs(Model model, @RequestParam String name, @RequestParam String _csrfToken, @RequestParam String category) {
        if(httpSession.getAttribute("user") != null) {
            User u = (User) httpSession.getAttribute("user");
            Blog blog = new Blog();
            blog.setName(name);
            blog.setSlug(u.getId() + "-" + name.replace(" ", "-").toLowerCase());
            blog.setCategory(category);
            blog.setCreated_at(LocalDate.now());
            blog.setUserSet(u);

            blogService.createBlog(blog);
            return "adminPanel/blogList";
        }
        model.addAttribute("csrfToken", _csrfToken);

        return "redirect:/";
    }

}
