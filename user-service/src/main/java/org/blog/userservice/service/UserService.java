package org.blog.userservice.service;

import org.blog.userservice.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> listUsers();

    User findUserById(Long id);

    String subscribeTo(Long currentUserId, Long subscribedUserId);
}
