package com.springboot.cred.repository;

import com.springboot.cred.model.Account;
import com.springboot.cred.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByUserId(String id);
}
