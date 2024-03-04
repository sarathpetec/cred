package com.springboot.cred.config;

import com.springboot.cred.model.Account;
import com.springboot.cred.model.Company;
import com.springboot.cred.model.User;
import com.springboot.cred.model.UserSecrets;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner commandLineRunner(MongoTemplate mongoTemplate) {
        return args -> {
            Company company =
                    Company.builder()
                            .id("1")
                            .code("NEXER")
                            .name("Nexer Group")
                            .location("Gothenburg")
                            .created_on(LocalDateTime.now())
                            .last_updated(LocalDateTime.now())
                            .build();
            User user_sarath =
                    User.builder()
                            .id("1")
                            .username("sarath")
                            .last_updated(LocalDateTime.now())
                            .email("sarath@nexergroup.com")
                            .created_on(LocalDateTime.now())
                            .build();
            User user_siva =
                    User.builder()
                            .id("2")
                            .email("siva@nexergroup.com")
                            .created_on(LocalDateTime.now())
                            .last_updated(LocalDateTime.now())
                            .username("siva")
                            .build();

            Account account_sarath = Account.builder()
                    .id("1")
                    .userId("sarath")
                    .companyId("1")
                    .status("active")
                    .created_on(LocalDateTime.now())
                    .last_updated(LocalDateTime.now())
                    .build();
            Account account_siva =
                    Account.builder()
                            .id("2")
                            .userId("siva")
                            .companyId("1")
                            .status("active")
                            .created_on(LocalDateTime.now())
                            .last_updated(LocalDateTime.now())
                            .build();

            UserSecrets userSecrets_sarath =
                    UserSecrets.builder()
                            .id("1")
                            .accountId("1")
                            .username("sarath")
                            .expiry_date(LocalDateTime.now())
                            .password("sarath123")
                            .created_on(LocalDateTime.now())
                            .last_updated(LocalDateTime.now())
                            .build();


            UserSecrets userSecrets_siva =
                    UserSecrets.builder()
                            .id("2")
                            .accountId("2")
                            .username("siva")
                            .expiry_date(LocalDateTime.now())
                            .password("siva123")
                            .created_on(LocalDateTime.now())
                            .last_updated(LocalDateTime.now())
                            .build();

            // Clear existing data
            mongoTemplate.dropCollection(User.class);
            mongoTemplate.dropCollection(Account.class);
            mongoTemplate.dropCollection(Company.class);
            mongoTemplate.dropCollection(UserSecrets.class);

            // Insert initial data
            mongoTemplate.insert(company);

            mongoTemplate.insert(user_sarath);
            mongoTemplate.insert(user_siva);

            mongoTemplate.insert(account_sarath);
            mongoTemplate.insert(account_siva);

            mongoTemplate.insert(userSecrets_sarath);
            mongoTemplate.insert(userSecrets_siva);
        };
    }
}
