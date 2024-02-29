package com.springboot.cred.repository;

import com.springboot.cred.model.User;
import com.springboot.cred.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository  extends MongoRepository<UserProfile, Integer> {


}
