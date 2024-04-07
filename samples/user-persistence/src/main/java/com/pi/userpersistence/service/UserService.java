package com.pi.userpersistence.service;

import com.pi.userpersistence.model.User;

public interface UserService {
    User save(User user);
    Iterable<User> listUsers();
}
