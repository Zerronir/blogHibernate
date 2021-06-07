package com.blog.services;

import com.blog.entities.Comments;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CommentService {
    Set<Comments> getAllByPostIdEquals(Long post_id);
}
