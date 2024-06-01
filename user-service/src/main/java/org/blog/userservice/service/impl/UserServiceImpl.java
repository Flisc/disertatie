package org.blog.userservice.service.impl;

import org.blog.userservice.model.User;
import org.blog.userservice.repository.UserRepository;
import org.blog.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public String subscribeTo(Long currentUserId, Long subscribedUserId) {
        Optional<User> currentUser = userRepository.findById(currentUserId);
        Optional<User> subscribedUser = userRepository.findById(subscribedUserId);
        if (!currentUser.isPresent()) {
            return "Current user not found";
        }
        if (!subscribedUser.isPresent()) {
            return "Subscribed user not found";
        }
        subscribedUser.get().getSubscribedUsers().add(currentUserId);
        userRepository.save(subscribedUser.get());

        return "Subscribed successfully";
    }
}
