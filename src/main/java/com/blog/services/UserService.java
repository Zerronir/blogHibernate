package com.blog.services;

import com.blog.entities.User;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public interface UserService {
    User findUserById(Long user_id);
    User findUserByEmail(String email);
    String encryptedPassword(String password) throws NoSuchAlgorithmException;
    User save(User user);
}
