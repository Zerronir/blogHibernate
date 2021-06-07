package com.blog.services;

import com.blog.entities.Blog;
import com.blog.entities.User;
import com.blog.repositories.BlogRepo;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Set;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepo blogRepo;

    @Override
    public Set<Blog> getAllByUserSetIdEquals(Long user_id) {
        return blogRepo.getAllByUserSetIdEquals(user_id);
    }

    @Override
    public Blog findBySlugEquals(String name) {
        return blogRepo.findBySlugEquals(name);
    }

    @Override
    public boolean createBlog(Blog blog) {
        try {
            blogRepo.save(blog);
            return true;
        }catch (QueryException ex) {
            return false;
        }
    }
}
