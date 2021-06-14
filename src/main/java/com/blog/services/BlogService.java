package com.blog.services;

import com.blog.entities.Blog;
import com.blog.entities.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BlogService {
    Blog findByIdEquals(Long blogId);
    Set<Blog> getAllByNameNotNull();
    Set<Blog> getAllByUserSetIdEquals(Long user_id);
    Set<Blog> findAllByUserSetNot(User user_id);
    Blog findBySlugEquals(String name);
    Long deleteByIdEquals(Long id);
    boolean createBlog(Blog blog);
}
