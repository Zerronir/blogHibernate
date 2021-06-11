package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.Category;
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
public class BlogViewController {
    @Autowired
    HttpSession httpSession;

    @Autowired
    BlogService blogService;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    // HEADER LINKS //
    @GetMapping("/{slug}")
    public String index(@PathVariable(value = "slug") String slug, Model model) {
        Blog blog = blogService.findBySlugEquals(slug);
        Set<Post> postList = postService.getAllByBlogIdEquals(blog.getId());
        model.addAttribute("blog", blog);
        model.addAttribute("postList", postList);
        return "blogView/index";
    }
    // FIN HEADER LINKS //

    @GetMapping("/{blogSlug}/{postSlug}")
    public String viewPostReader(@PathVariable(value = "blogSlug") String blogSlug, @PathVariable(value = "postSlug") String postSlug, Model model) {
        Blog blog = blogService.findBySlugEquals(blogSlug);
        Post post = postService.findBySlugEquals(postSlug);
        Set<UserComments> comments = commentService.findAllByPost_idEquals(post);

        model.addAttribute("post", post);
        model.addAttribute("blog", blog);
        model.addAttribute("comments", comments);

        return "blogView/postView";
    }

}
