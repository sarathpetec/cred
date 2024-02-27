package com.springboot.cred.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    private String currentRole;
    private String email;
    private List<Skill> skillList;
    private List<WorkExperience> workExperienceList;

}
