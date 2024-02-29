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
@Document(collection = "credentialManager")
public class UserSecrets {

    @Id
    private String id;
    private String accountId;

    private String username;
    private String password;
    private LocalDateTime created_on;

    private LocalDateTime expiry_date;
    private LocalDateTime last_updated;


}
