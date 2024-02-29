package com.springboot.cred.service;

import com.springboot.cred.model.UserProfile;
import com.springboot.cred.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public void addUserProfile(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }
}
