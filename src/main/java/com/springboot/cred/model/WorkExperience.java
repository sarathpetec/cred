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
@Document(collection = "user_profile")
public class WorkExperience {

    @Id
    private String id;
    private String userId;
    private String companyName;
    private LocalDateTime start_year;
    private LocalDateTime end_year;
    private boolean onGoing;
    private String role;
    private LocalDateTime created_on;
    private LocalDateTime last_updated;

}
