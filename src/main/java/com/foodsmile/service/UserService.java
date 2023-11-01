package com.foodsmile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.foodsmile.model.User;
import com.foodsmile.repository.UserRepository;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<User> getAllUsers() {
        logger.info("Getting all users");
        List<User> users = repository.findAll();
        logger.info("Found {} users", users.size());
        return users;
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    public User createUser(User user) {
        String hashedPassword = encoder.encode(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);
        return repository.save(user);
    }

    public User authenticateUser(String email, String rawPassword) {
        User foundUser = repository.findByEmail(email);
        if (foundUser != null && encoder.matches(rawPassword, foundUser.getPasswordHash())) {
            return foundUser;
        }
        return null;
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}


