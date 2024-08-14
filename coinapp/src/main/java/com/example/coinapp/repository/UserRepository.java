package com.example.coinapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.coinapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
