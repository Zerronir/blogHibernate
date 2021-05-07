package com.blog.repositories;

import com.blog.entities.Person;
import com.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    User findUserById(Long user_id);
    User findUserByEmail(String email);
}
