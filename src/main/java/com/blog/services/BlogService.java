package com.blog.services;

import com.blog.entities.Blog;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Set;

@Service
public interface BlogService {
    Set<Blog> getAllByUserSetIdEquals(Long user_id);
    Blog findByNameEquals(String name);
    boolean createBlog(Blog blog);
}
