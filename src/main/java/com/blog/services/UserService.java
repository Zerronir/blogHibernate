package com.blog.services;

import com.blog.entities.User;
import com.blog.repositories.PersonRepo;
import com.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findUserById(Long user_id);
    User findUserByEmail(String email);
}
