package com.blog.repositories;

import com.blog.entities.Blog;
import com.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {
    Blog findByIdEquals(Long blogId);
    Set<Blog> getAllByNameNotNull();
    Set<Blog> getAllByUserSetIdEquals(Long user_id);
    Set<Blog> findAllByUserSetNot(User user_id);
    Blog findBySlugEquals(String name);
    Blog save(Blog blog);
}
