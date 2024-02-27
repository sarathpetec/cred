package com.springboot.cred.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkExperience {

    private String orgName;
    private LocalDateTime start_year;
    private LocalDateTime end_year;

    private boolean onGoing;
    private String role;

}
