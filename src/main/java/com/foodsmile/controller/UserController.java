package com.foodsmile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.foodsmile.model.User;
import com.foodsmile.service.UserService;
import com.foodsmile.util.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        logger.info("Registering user with email: {}", user.getEmail());
        User existingUser = service.findByEmail(user.getEmail());
        if (existingUser != null) {
            logger.warn("Email already exists: {}", user.getEmail());
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }
        User createdUser = service.createUser(user);
        logger.info("User registered successfully: {}", createdUser.getUserId());
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setUserId(id);
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User authenticatedUser = service.authenticateUser(user.getEmail(), user.getPasswordHash());
        if (authenticatedUser != null) {
            String token = JwtUtil.generateToken(authenticatedUser);
            Map<String, Object> response = new HashMap<>();
            response.put("user", authenticatedUser);
            response.put("token", token);
            logger.info("User logged in: {} ", authenticatedUser );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            logger.info("Authentication failed: {} ", user.getEmail() );
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }
}
