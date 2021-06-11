package com.blog.repositories;

import com.blog.entities.Post;
import com.blog.entities.UserComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommentRepo extends JpaRepository<UserComments, Long> {
    //Set<UserComments> getAllByPost_idEquals(Long post_id);
    Set<UserComments> findAllByPost(Post post);
    UserComments save(UserComments comment);
}
