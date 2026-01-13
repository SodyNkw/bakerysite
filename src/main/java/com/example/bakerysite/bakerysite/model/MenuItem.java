package com.example.bakerysite.bakerysite.model;

import org.springframework.data.annotation.Id;

public class MenuItem {

    @Id
    private String itemId;
    private String itemName;
    private double itemPrice;


    public String getItemName(){
        return itemName;
    }

    public void setItemName(String name){
        this.itemName = name;
    }

    public String getItemId(){
        return itemId;
    }

    public void setItemId(String itemId){
        this.itemId = itemId;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public void setItemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }
}
