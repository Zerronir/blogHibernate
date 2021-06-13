package com.blog.controllers;

import com.blog.entities.Blog;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.entities.UserComments;
import com.blog.services.BlogService;
import com.blog.services.CommentService;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class CommentController {
    LocalDate localDate = LocalDate.now();

    @Autowired
    HttpSession httpSession;

    @Autowired
    PostService postService;

    @Autowired
    BlogService blogService;

    @Autowired
    CommentService commentService;

    @PostMapping("/postComment")
    public String createCommentForPost(@RequestParam String commentContent, @RequestParam Long postId) {
        if(postId > 0) {
            Post post = postService.findByIdEquals(postId);
            Blog blog = blogService.findByIdEquals(post.getBlog().getId());
            if(commentContent.length() < 150) {
                User u = (User) httpSession.getAttribute("user");
                UserComments comment = new UserComments();
                comment.setPost(post);

                if (u != null) {
                    comment.setUser_id(u);
                }

                comment.setPosted_at(localDate);
                comment.setText(commentContent);
                commentService.save(comment);

                return "redirect:/"+blog.getSlug()+"/"+post.getSlug();

            }
            return "redirect:/"+blog.getSlug()+"/"+post.getSlug();
        } else {
            return "redirect:/";
        }
    }
}
