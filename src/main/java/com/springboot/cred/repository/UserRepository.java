package com.springboot.cred.repository;

import com.springboot.cred.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findUserByUsername(String name);
}
