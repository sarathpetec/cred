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
@Document(collection = "languages")
public class LanguageProficiency {

    @Id
    private int id;
    private String language;
    private Proficiency proficiency;
    private int userId;
    private LocalDateTime created_on;
    private LocalDateTime last_updated;
}
