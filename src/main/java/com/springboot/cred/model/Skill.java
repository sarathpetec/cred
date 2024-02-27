package com.springboot.cred.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "skills")
public class Skill {

    @Id
    private int id;
    private String skillName;
    private Proficiency proficiency;
    private String userId;
    private LocalDateTime created_on;
    private LocalDateTime updated_on;

}

