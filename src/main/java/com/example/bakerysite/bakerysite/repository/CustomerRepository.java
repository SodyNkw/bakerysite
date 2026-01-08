package com.example.bakerysite.bakerysite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bakerysite.bakerysite.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
