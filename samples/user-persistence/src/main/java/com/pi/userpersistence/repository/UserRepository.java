package com.pi.userpersistence.repository;

import com.pi.userpersistence.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{
}
