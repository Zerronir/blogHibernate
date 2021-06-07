package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.Comments;
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

    @Autowired
    CommentService commentService;

    @GetMapping("/admin/{blogSlug}/{postSlug}")
    public String viewPost(@PathVariable(value = "blogSlug") String blog, @PathVariable(value = "postSlug") String post) {

        if(httpSession.getAttribute("user") != null) {

            return "adminBlog/post";
        }

        return "redirect:/";
    }

    @GetMapping("/{blogSlug}/{postSlug}")
    public String viewPostReader(@PathVariable(value = "blogSlug") String blogSlug, @PathVariable(value = "postSlug") String postSlug, Model model) {
        Blog blog = blogService.findBySlugEquals(blogSlug);
        Post post = postService.findBySlugEquals(postSlug);
        Set<Comments> commentsList = commentService.getAllByPostIdEquals(post.getId());

        model.addAttribute("post", post);
        model.addAttribute("blog", blog);
        model.addAttribute("comments", commentsList);

        return "blogView/postView";
    }

}
