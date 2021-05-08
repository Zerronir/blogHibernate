package com.blog.services;

import com.blog.entities.Blog;
import com.blog.repositories.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Blog findByNameEquals(String name) {
        return blogRepo.findByNameEquals(name);
    }
}
