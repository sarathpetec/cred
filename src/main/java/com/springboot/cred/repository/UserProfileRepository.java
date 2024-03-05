package com.springboot.cred.repository;

import com.springboot.cred.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserProfileRepository  extends MongoRepository<UserProfile, String> {


    Optional<UserProfile> findByUserId(String id);
}
