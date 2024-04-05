package com.pi.userpersistence;

import com.pi.userpersistence.model.User;
import com.pi.userpersistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
//@EnableKafka
public class UserPersistenceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UserPersistenceApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
//		 userService.save(User.builder().userName("user1").build());
//		 userService.save(User.builder().userName("user2").build());
//		 userService.save(User.builder().userName("user3").build());
		 userService.listUsers().forEach(user -> { System.out.println(user.getEmail());});
	}
}
