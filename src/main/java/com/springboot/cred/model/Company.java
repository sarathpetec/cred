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
@Document(collection = "companies")
public class Company {

    @Id
    private String id;
    private String name;
    private String code;
    private String location;
    private LocalDateTime created_on;
    private LocalDateTime last_updated;

}
