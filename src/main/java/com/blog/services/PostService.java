package com.blog.services;

import com.blog.entities.Category;
import com.blog.entities.Comments;
import com.blog.entities.Post;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PostService {
    Set<Post> getAllByBlogIdEquals(Long blog_id);
    //Set<Post> getAllByCategoryEquals(Long catId);
    Post findByIdEquals(Long post_id);
    Post findBySlugEquals(String slug);
    Post save(Post post);
}
