package com.sl.jpa;

//import lombok.extern.slf4j.Slf4j;
//import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sl.jpa.Customer;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

// ref: https://www.youtube.com/watch?v=1kLwwsfghgE&t=1939s

//@Slf4j
@DataJpaTest
// disable use default h2 for test. Use the database specifyed application.properties
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustumerTest {

    Logger logger = LoggerFactory.getLogger(CustumerTest.class);

    @Autowired
    CustomerRepository repository;

    @Test
    public void findByLastNameTest() {

        List<Customer>  lista = repository.findByLastName("Bauer")
                .stream().collect(Collectors.toList());
        //assertEquals("size incorrect", 2, students.size());
        assertNotNull("Customer found with findByLastName('Bauer'):", lista);
        logger.info(lista.toString());
    }

}
