package com.sl.jpa;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void updateCustomerRepository() {
        Customer customer = new Customer("Silvio", "Limeira");
        customerRepository.save(customer);
    }

}
