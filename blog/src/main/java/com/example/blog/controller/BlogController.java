package com.example.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

//    private final UserService userService;
//    public BlogController(final UserService userService) {
//        this.userService = userService;
//    }

//    @GetMapping("/users")
//    public List<User> listUsers() {
//        return StreamSupport
//                .stream(userService.listUsers().spliterator(), false)
//                .collect(Collectors.toList());
//    }

    @GetMapping("/hello")
    public ResponseEntity listUsers() {
        return ResponseEntity.ok("Hello");
    }
}