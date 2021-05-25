package com.blog.services;

import com.blog.entities.Post;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PostService {
    Set<Post> getAllByBlogIdEquals(Long blog_id);
    Post findByIdEquals(Long post_id);
    Post save(Post post);
}
