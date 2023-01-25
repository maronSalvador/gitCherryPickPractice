package com.springbootcrudwebservicesapp.springbootcrudwebservicesapp.controller;

import com.springbootcrudwebservicesapp.springbootcrudwebservicesapp.entity.User;
import com.springbootcrudwebservicesapp.springbootcrudwebservicesapp.exception.ResourceNotFoundException;
import com.springbootcrudwebservicesapp.springbootcrudwebservicesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with user id" + userId));
    }

    // Create user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    // Update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") long userId) {
        User existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with user id" + userId));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return this.userRepository.save(existingUser);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@RequestBody User user, @PathVariable("id") long userId) {
        User existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with user id" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}
