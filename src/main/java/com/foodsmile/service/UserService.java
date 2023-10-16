package com.foodsmile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import com.foodsmile.model.User;
import com.foodsmile.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
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

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
}

