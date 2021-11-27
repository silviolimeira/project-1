package com.sl.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// ref: https://www.youtube.com/watch?v=1kLwwsfghgE&t=1939s

@DataJpaTest
// disable use default h2 for test. Use the database specifyed application.properties
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class CustumerTest {

    @Autowired
    CustomerRepository repository;

    @Test
    public void findByLastNameTest() {
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        repository.findByLastName("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });
    }

}
