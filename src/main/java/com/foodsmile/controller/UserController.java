package com.foodsmile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.foodsmile.model.User;
import com.foodsmile.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

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
        User existingUser = service.findByEmail(user.getEmail());
        if (existingUser != null) {
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }
        User createdUser = service.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
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
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }
}
