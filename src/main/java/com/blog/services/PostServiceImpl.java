package com.blog.services;

import com.blog.entities.Post;
import com.blog.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;

    @Override
    public Set<Post> getAllByBlogIdEquals(Long blog_id) {
        return postRepo.getAllByBlogIdEquals(blog_id);
    }

    @Override
    public Post findByIdEquals(Long post_id) {
        return postRepo.findByIdEquals(post_id);
    }

    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }
}
