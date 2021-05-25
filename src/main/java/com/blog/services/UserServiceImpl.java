package com.blog.services;

import com.blog.entities.User;
import com.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public User findUserById(Long user_id) {
        return userRepo.findUserById(user_id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    // Custom methods
    public String encryptedPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());
        byte[] dg = md.digest();
        StringBuilder hexString = new StringBuilder();
        for(byte b : dg) {
            hexString.append(Integer.toHexString(0xFF & b));
        }
        return hexString.toString();
    }
}
