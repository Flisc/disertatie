package org.blog.userservice.controller;

import org.blog.userservice.faker.SeedService;
import org.blog.userservice.model.User;
import org.blog.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping()
//    public List<User> listUsers() {
//        return userService.listUsers();
//    }

    @GetMapping("/register_user")
    public ResponseEntity<User> registerUser() {
        return ResponseEntity.ok(userService.save(SeedService.randomUser()));
    }
}
