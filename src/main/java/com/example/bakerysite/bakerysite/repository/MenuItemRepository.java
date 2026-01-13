package com.example.bakerysite.bakerysite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.bakerysite.bakerysite.model.MenuItem;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
    
}
