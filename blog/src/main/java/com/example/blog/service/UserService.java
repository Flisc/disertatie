package com.example.blog.service;


import com.example.blog.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> listUsers();

    User findUserById(Long id);

    void test() throws Exception;
}
