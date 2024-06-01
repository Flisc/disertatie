package org.blog.userservice.controller;

import org.blog.userservice.faker.SeedService;
import org.blog.userservice.model.User;
import org.blog.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/create")
    public ResponseEntity<User> registerUser() {
        return ResponseEntity.ok(userService.save(SeedService.randomUser()));
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ofNullable(userService.findUserById(id));
    }

    @GetMapping("/users/{currentUserId}/subscribe/{subscribedUserId}")
    public ResponseEntity<String> subscribeTo(@PathVariable Long currentUserId, @PathVariable Long subscribedUserId) {
        return ResponseEntity.ofNullable(userService.subscribeTo(currentUserId, subscribedUserId));
    }
}
