package com.blog.entities;

import jdk.vm.ci.meta.Local;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String category;
    LocalDate created_at;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    @Nullable
    User userSet;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    @Nullable
    public User getUserSet() {
        return userSet;
    }

    public void setUserSet(@Nullable User userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, category);
    }
}
