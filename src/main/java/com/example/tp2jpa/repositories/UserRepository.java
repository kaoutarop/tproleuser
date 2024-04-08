package com.example.tp2jpa.repositories;

import com.example.tp2jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String useName);
}
