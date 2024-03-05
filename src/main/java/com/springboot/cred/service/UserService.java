package com.springboot.cred.service;

import com.springboot.cred.model.Account;
import com.springboot.cred.model.User;
import com.springboot.cred.model.UserProfile;
import com.springboot.cred.repository.AccountRepository;
import com.springboot.cred.repository.UserProfileRepository;
import com.springboot.cred.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private AccountRepository accountRepository;
    private String id;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public UserProfile getUserById(String id) {
        if (userRepository.existsById(id)) {
            Account account = accountRepository.findByUserId(id).orElseThrow(IllegalArgumentException::new);
            if (account.getStatus().equalsIgnoreCase("ACTIVE")) {
                return userProfileRepository.findByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Account is not active"));
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Id does not exist");
    }



    public Iterable<User> getUsersByName(String name) {
        return userRepository.findUserByUsername(name);
    }
}
