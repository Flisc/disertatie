package org.blog.userservice.faker;


import com.github.javafaker.Faker;
import org.blog.userservice.model.User;
import org.blog.userservice.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

public class SeedService {

    private static final Faker faker = new Faker();
    private final UserRepository userRepository;

    public SeedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void populateUsers(final Integer noOfUsers) {
        for (int i = 0; i < noOfUsers; i++) {
            userRepository.save(randomUser());
        }
    }

    public static User randomUser() {
        return User.builder()
                .email(faker.internet().emailAddress())
                .userName(faker.name().username())
                .subscribedAuthors(new HashSet<>())
                .build();
    }

    public static User randomUserFrom(final List<User> users) {
        return users.get(faker.random().nextInt(users.size()));
    }

}
