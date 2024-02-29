package com.springboot.cred.service;

import com.springboot.cred.model.User;
import com.springboot.cred.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUserById(String id) {
       return userRepository.findById(id);
    }

    public Iterable<User> getUsersByName(String name) {
        return userRepository.findUserByUsername(name);
    }
}
