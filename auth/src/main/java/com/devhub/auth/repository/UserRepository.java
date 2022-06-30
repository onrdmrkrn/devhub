package com.devhub.auth.repository;

import com.devhub.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
    public User findUserByUserMail(String mail);
    public User findByUserId(int userId);
}
