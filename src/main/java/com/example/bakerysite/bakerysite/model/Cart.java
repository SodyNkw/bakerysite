package com.example.bakerysite.bakerysite.model;

import org.springframework.data.annotation.Id;

public class Cart {

    @Id
    private String cartId;
    private MenuItem menuItem;
    
}
