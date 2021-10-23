package com.sl.javafuncional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "99999");
        // Example Consumer Functional Interface
        greetCustomerConsumer.accept(maria);

        System.out.println("\n// Example BiConsumer\n");
        Customer junior = new Customer("Júnior", "888888");
        greetCustomerConsumerV2.accept(maria, false);
        greetCustomerConsumerV2.accept(maria, true);

    }

    // Example Consumer Functional Interface
    static Consumer<Customer> greetCustomerConsumer =
        customer -> {
            System.out.println(String.format("Hello %s, thanks for registering phone number %s\n", customer.customerName, customer.customerPhoneNumber));
            int b = 2;
        };

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> {
        System.out.println(String.format("Hello %s, thanks for registering phone number %s\n",
                customer.customerName,
                (showPhoneNumber ? customer.customerPhoneNumber: "*********")));
        int b = 2; // TODO: cut this line of code only example block
    };

    static class Customer {

        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }



}
