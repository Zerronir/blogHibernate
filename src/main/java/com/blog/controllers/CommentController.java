package com.blog.controllers;

import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.entities.UserComments;
import com.blog.services.CommentService;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    HttpSession httpSession;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @PostMapping("/postComment")
    public String createCommentForPost(@RequestParam String content, @RequestParam Long postId) {
        if(content.length() < 150) {
            User u = (User) httpSession.getAttribute("user");

            Post post = postService.findByIdEquals(postId);
            UserComments comment = new UserComments();
            comment.setPost(post);
            if (u.getId() != null) {
                comment.setUser_id(u);
            }
            comment.setText(content);
            commentService.save(comment);
        }
        return "redirect:/";
    }
}
