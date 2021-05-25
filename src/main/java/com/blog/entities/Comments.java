package com.blog.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    LocalDate posted_at;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    @Nullable
    User comment_author;

    @OneToOne(optional = true)
    @JoinColumn(name = "posts_id", nullable = false)
    Post original_post;

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
    public User getComment_author() {
        return comment_author;
    }

    public void setComment_author(@Nullable User comment_author) {
        this.comment_author = comment_author;
    }

    public Post getOriginal_post() {
        return original_post;
    }

    public void setOriginal_post(Post original_post) {
        this.original_post = original_post;
    }
}
