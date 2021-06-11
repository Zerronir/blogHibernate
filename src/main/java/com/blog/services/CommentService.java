package com.blog.services;

import com.blog.entities.Post;
import com.blog.entities.UserComments;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CommentService {
    public Set<UserComments> findAllByPost_idEquals(Post post_id);
    UserComments save(UserComments comment);
}
