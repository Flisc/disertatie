package org.blog.userservice;

import org.blog.userservice.faker.SeedService;
import org.blog.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.blog.userservice"})
public class UserServiceApplication implements CommandLineRunner {
	@Autowired
	private UserRepository  userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		populateUsers(1000);
	}

	public void populateUsers(final Integer noOfUsers) {
		for (int i = 0; i < noOfUsers; i++) {
			userRepository.save(SeedService.randomUser());
		}
	}
}
