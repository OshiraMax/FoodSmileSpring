package com.foodsmile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsmile.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
