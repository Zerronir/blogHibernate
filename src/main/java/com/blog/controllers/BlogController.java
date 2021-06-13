package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.services.BlogService;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // ADMIN SECTION //
    @GetMapping("/admin/{slug}")
    public String blogAdmin(@PathVariable(value = "slug") String slug, Model model) {

        if(httpSession.getAttribute("user") != null) {
            Blog blog = blogService.findBySlugEquals(slug);
            model.addAttribute("blog", blog);
            return "adminBlog/index";
        }

        return "redirect:/";
    }

    @GetMapping("/admin/{slug}/postList")
    public String postList(@PathVariable(value = "slug") String slug, Model model) {

        if(httpSession.getAttribute("user") != null) {
            Blog blog = blogService.findBySlugEquals(slug);
            Set<Post> postList = postService.getAllByBlogIdEquals(blog.getId());
            int postCount = postList.size();
            model.addAttribute("blog", blog);
            model.addAttribute("postList", postList);
            model.addAttribute("postCount", postCount);
            return "adminBlog/postList";
        }

        return "redirect:/";
    }

    @GetMapping("/admin/{slug}/createPost")
    public String createPostGet(@PathVariable(value="slug") String slug, Model model) {
        if(httpSession.getAttribute("user") != null) {
            Blog blog = blogService.findBySlugEquals(slug);
            model.addAttribute("blog", blog);
            return "adminBlog/createPost";
        }
        return "redirect:/";
    }

    @PostMapping("/admin/{slug}/createPost")
    public String createPostPost(@PathVariable(value = "slug") String slug, @RequestParam String _csrfToken, @RequestParam String title, @RequestParam String content) {
        if(httpSession.getAttribute("user") != null) {
            User author = (User) httpSession.getAttribute("user");
            Blog blog = blogService.findBySlugEquals(slug);
            Post post = new Post();
            post.setName(title);
            post.setBlog(blog);
            post.setContent(content);
            post.setSlug(author.getId() + "-" + title.replace(" ", "-").toLowerCase());
            post.setAuthor(author);
            postService.save(post);

            return "redirect:/admin/"+slug;
        }

        return "redirect:/";
    }

    @GetMapping("/admin/{slug}/updatePost/{post}")
    public String updatePostGet(@PathVariable(value = "slug") String slug, @PathVariable(value = "post") String post, Model model) {
        if(httpSession.getAttribute("user") != null) {
            Post upd = postService.findBySlugEquals(post);
            Blog blog = blogService.findBySlugEquals(slug);
            model.addAttribute("post", upd);
            model.addAttribute("blog", blog);
            return "/adminBlog/updatePost";
        }

        return "redirect:/";
    }

    @PostMapping("/admin/{slug}/updatePost/{post}")
    public String updatePost(@PathVariable(value = "slug") String blog, @PathVariable(value = "post") String postSlug, @RequestParam String title, @RequestParam String _csrfToken, @RequestParam String content) {
        if(httpSession.getAttribute("user") != null) {
            User u = (User) httpSession.getAttribute("user");
            Post post = postService.findBySlugEquals(postSlug);
            post.setName(title);
            post.setContent(content);
            postService.save(post);
            return "redirect:/admin/"+blog;
        }

        return "redirect:/";
    }

    // END ADMIN SECTION //


}
