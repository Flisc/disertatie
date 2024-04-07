package com.pi.userpersistence.controller;

import com.pi.userpersistence.model.User;
import com.pi.userpersistence.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return StreamSupport
                .stream(userService.listUsers().spliterator(), false)
                .collect(Collectors.toList());
    }
}
