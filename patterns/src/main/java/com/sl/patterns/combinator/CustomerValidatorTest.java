package com.sl.patterns.combinator;

import java.time.LocalDate;

public class CustomerValidatorTest {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "0825464646",
                LocalDate.of(2000,1,1)
        );

        // Using combinator pattern
        CustomerValidator.ValidationResult result = CustomerValidator
                .isEmailValid()
                .and(CustomerValidator.isPhoneNumberValid())
                .and(CustomerValidator.isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != CustomerValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }

}
