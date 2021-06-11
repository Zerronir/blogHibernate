package com.blog.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "comments")
public class UserComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    LocalDate posted_at;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id")
    @Nullable
    User user_id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(LocalDate posted_at) {
        this.posted_at = posted_at;
    }

    @Nullable
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(@Nullable User user_id) {
        this.user_id = user_id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post_id) {
        this.post = post_id;
    }
}
