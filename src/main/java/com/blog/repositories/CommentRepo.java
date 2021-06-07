package com.blog.repositories;

import com.blog.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {
    Set<Comments> getAllByPostIdEquals(Long post_id);
}
