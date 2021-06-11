package com.blog.services;

import com.blog.entities.UserComments;
import com.blog.entities.Post;
import com.blog.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;

    @Override
    public Set<Post> getAllByBlogIdEquals(Long blog_id) {
        return postRepo.getAllByBlogIdEquals(blog_id);
    }

    /*@Override
    public Set<Post> getAllByCategoryEquals(Long category) {
        return postRepo.getAllByCategoryEquals(category);
    }*/

    @Override
    public Post findByIdEquals(Long post_id) {
        return postRepo.findByIdEquals(post_id);
    }

    @Override
    public Post findBySlugEquals(String slug) {
        return postRepo.findBySlugEquals(slug);
    }

    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }
}
