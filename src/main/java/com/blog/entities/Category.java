package com.blog.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String category_name;

    @OneToMany
    @JoinColumn(name = "post_id")
    @Nullable
    Set<Post> postList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Nullable
    public Set<Post> getPostList() {
        return postList;
    }

    public void setPostList(@Nullable Set<Post> postList) {
        this.postList = postList;
    }
}
