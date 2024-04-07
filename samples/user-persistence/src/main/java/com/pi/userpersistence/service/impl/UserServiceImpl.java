package com.pi.userpersistence.service.impl;

import com.pi.userpersistence.model.User;
import com.pi.userpersistence.repository.UserRepository;
import com.pi.userpersistence.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }
}
