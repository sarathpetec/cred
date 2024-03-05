package com.springboot.cred.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user_profiles")
public class UserProfile {

    @Id
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    private String currentRole;
    private List<Skill> skills;
    private List<Language> languages;
    private List<WorkExperience> workExperiences;
    private LocalDateTime created_on;
    private LocalDateTime last_updated;

}
