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
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;
    private String userId;
    private String companyId;
    private String status;
    private LocalDateTime created_on;
    private LocalDateTime last_updated;

}
