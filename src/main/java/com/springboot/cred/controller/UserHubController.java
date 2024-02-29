package com.springboot.cred.controller;

import com.springboot.cred.model.User;
import com.springboot.cred.model.UserProfile;
import com.springboot.cred.service.UserProfileService;
import com.springboot.cred.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Controller
public class UserHubController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;

    @QueryMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public Optional<User> getUserById(@Argument String id) {
        return userService.getUserById(id);
    }

    @QueryMapping
    public Iterable<User> getUsersByName(@Argument String name){
        return userService.getUsersByName(name);
    }
    @MutationMapping
    public User addUser(@Argument UserInput userInput) {

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(userInput.firstName()+"_"+userInput.lastName());
        user.setEmail(userInput.email());
        userService.addUser(user);


        UserProfile userProfile = new UserProfile();
        userProfile.setId(UUID.randomUUID().toString());
        userProfile.setUserId(user.getId());
        userProfile.setFirstName(userInput.firstName());
        userProfile.setLastName(userInput.lastName());
        userProfile.setCurrentRole(userInput.role());
        userProfile.setYearsOfExperience(userInput.yearsOfExperience());
        userProfile.setCreated_on(LocalDateTime.now());
        userProfile.setLast_updated(null);
        userProfileService.addUserProfile(userProfile);

        return user;
    }

    public record UserInput(String firstName,String lastName,String email,int yearsOfExperience,String role) {

    }


}
