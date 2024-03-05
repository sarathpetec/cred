package com.springboot.cred.controller;

import com.springboot.cred.model.*;
import com.springboot.cred.service.UserProfileService;
import com.springboot.cred.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public UserProfile getUserById(@Argument String id) {
        return userService.getUserById(id);
    }

    @QueryMapping
    public Iterable<User> getUsersByName(@Argument String name){
        return userService.getUsersByName(name);
    }

    @MutationMapping
    public UserProfile addUserProfile(@Argument AddUserProfileInput userInput) {

        /*User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(userInput.firstName()+"_"+userInput.lastName());
        userService.addUser(user);*/

        UserProfile userProfile = new UserProfile();
        userProfile.setId(UUID.randomUUID().toString());
        userProfile.setUserId("1");
        userProfile.setFirstName(userInput.firstName());
        userProfile.setLastName(userInput.lastName());
        userProfile.setCurrentRole(userInput.role());
        userProfile.setYearsOfExperience(userInput.yearsOfExperience());
        userProfile.setCreated_on(LocalDateTime.now());
        userProfile.setLast_updated(null);

        // Map skills
        List<Skill> skills = userInput.skills().stream()
                .map(skillInput -> new Skill(skillInput.skillName(), skillInput.proficiency()))
                .collect(Collectors.toList());
        userProfile.setSkills(skills);

        // Map languages
        List<Language> languages = userInput.languages().stream()
                .map(languageInput -> new Language(languageInput.languageName(), languageInput.languageLevel()))
                .collect(Collectors.toList());
        userProfile.setLanguages(languages);

        // Map Work Experiences

        userProfileService.addUserProfile(userProfile);
        return userProfile;
    }

    public record AddUserProfileInput(String firstName,String lastName,int yearsOfExperience,String role, List<SkillInput> skills, List<LanguageInput> languages) {}

    public record SkillInput(String skillName, Proficiency proficiency){}

    public record LanguageInput(String languageName,LanguageLevel languageLevel){}

}
