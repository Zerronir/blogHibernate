package com.blog.repositories;

import com.blog.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {
    Set<Blog> getAllByUserSetIdEquals(Long user_id);
    Blog findBySlugEquals(String name);
    Blog save(Blog blog);
}
