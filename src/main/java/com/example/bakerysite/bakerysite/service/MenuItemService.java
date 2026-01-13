package com.example.bakerysite.bakerysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bakerysite.bakerysite.model.MenuItem;
import com.example.bakerysite.bakerysite.repository.MenuItemRepository;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItem addMenuItem(@RequestBody MenuItem menuItem){
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getAllMenuItems(){
        return menuItemRepository.findAll();
    }
    
}
