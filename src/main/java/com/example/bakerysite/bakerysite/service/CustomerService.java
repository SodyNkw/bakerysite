package com.example.bakerysite.bakerysite.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bakerysite.bakerysite.model.Customer;
import com.example.bakerysite.bakerysite.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(@RequestBody Customer customer){
        customer.setOrderDateTime(Instant.now());
        return customerRepository.save(customer);

    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    
}
