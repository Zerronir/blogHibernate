package com.blog.services;

import com.blog.entities.Post;
import com.blog.entities.UserComments;
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
    public Set<UserComments> findAllByPost_idEquals(Post post_id) {
        return commentRepo.findAllByPost(post_id);
    }

    @Override
    public UserComments save(UserComments comment) {
        return commentRepo.save(comment);
    }
}
