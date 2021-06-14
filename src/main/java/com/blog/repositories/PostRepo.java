package com.blog.repositories;

import com.blog.entities.UserComments;
import com.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    Set<Post> getAllByBlogIdEquals(Long blog_id);
    //Set<Post> getAllByCategoryEquals(Long catId);
    Post findByIdEquals(Long post_id);
    Post findBySlugEquals(String slug);
    Long deleteByIdEquals(Long id);
    Post save(Post post);
}
