package com.example.blog.faker;

import com.example.blog.model.Article;
import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
public class SeedService {

    private static final Faker faker = new Faker();
    private final UserRepository userRepository;

    public SeedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * .isMultiselectAllowed(faker.bool().bool())
     * .description(faker.lorem().sentence(20, 100))
     * .title(faker.lorem().sentence(5, 10))
     * faker.number().numberBetween(1, 3);
     * faker.crypto().sha512()
     */

    public static Article article(final List<User> authors) {
        return Article.builder()
                .title(faker.book().title())
                .body(faker.lorem().sentence(10, 20))
                .published(LocalDateTime.now())
                .author_id(authors.get(faker.random().nextInt(authors.size())).getId())
                .build();
    }

    public static Article article(final Long authorId) {
        return Article.builder()
                .title(faker.book().title())
                .body(faker.lorem().sentence(10, 10))
                .published(LocalDateTime.now())
                .author_id(authorId)
                .build();
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
