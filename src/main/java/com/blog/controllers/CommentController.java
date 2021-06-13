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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
                comment.setApproved(0);

                if (u != null) {
                    comment.setUser_id(u);
                    comment.setApproved(1);
                }


                comment.setPosted_at(localDate);
                comment.setText(commentContent.replace("<script>", "").replace("</script>", ""));
                commentService.save(comment);

                return "redirect:/"+blog.getSlug()+"/"+post.getSlug();

            }
            return "redirect:/"+blog.getSlug()+"/"+post.getSlug();
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/approveComment/{id}")
    public String aporvarComentari(@PathVariable(value = "id") Long id) {
        UserComments uc = commentService.findByIdEquals(id);
        Post p = postService.findByIdEquals(uc.getPost().getId());
        Blog b = blogService.findByIdEquals(p.getBlog().getId());
        uc.setApproved(1);
        commentService.save(uc);
        return "redirect:/"+b.getSlug()+"/"+p.getSlug();
    }

    @GetMapping("/deleteComment/{id}")
    public String eliminarComentari(@PathVariable(value = "id") Long id, Model model) {
        if(httpSession.getAttribute("user") != null) {
            UserComments uc = commentService.findByIdEquals((Long) id);
            Post p = postService.findByIdEquals(uc.getPost().getId());
            Blog b = blogService.findByIdEquals(p.getBlog().getId());
            if(commentService.deleteByIdEquals(uc.getId()) == 1L) {
                return "redirect:/"+b.getSlug()+"/"+p.getSlug();
            }
            model.addAttribute("error", "Error al eliminar el comentari");
        }
        return "redirect:/";
    }

}
