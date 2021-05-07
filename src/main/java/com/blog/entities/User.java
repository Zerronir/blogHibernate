package com.blog.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastname;
    String nickname;
    String email;
    LocalDate created_at;
    LocalDate updated_at;

    @OneToMany
    @JoinColumn(name = "blog_id", nullable = true)
    @Nullable
    Set<Blog> blog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    @Nullable
    public Set<Blog> getBlog() {
        return blog;
    }

    public void setBlog(@Nullable Set<Blog> blog) {
        this.blog = blog;
    }

    // Overrided methods
    @Override
    public String toString() {
        return String.format("(%d) %s %s %s %s %s %s", id, name, lastname, nickname, email, created_at, updated_at);
    }

}
