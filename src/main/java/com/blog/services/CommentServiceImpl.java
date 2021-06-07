package com.blog.services;

import com.blog.entities.Comments;
import com.blog.repositories.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepo commentRepo;

    @Override
    public Set<Comments> getAllByPostIdEquals(Long post_id) {
        return commentRepo.getAllByPostIdEquals(post_id);
    }
}
