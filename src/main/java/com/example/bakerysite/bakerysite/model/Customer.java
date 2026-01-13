package com.example.bakerysite.bakerysite.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "customers") // Mongo collection
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    @CreatedDate
    private Instant orderedAt;
    private Cart cart;

    public Customer() {}

    public Customer(String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Instant getOrderDateTime() { return orderedAt; }
    public void setOrderDateTime(Instant orderedAt) { this.orderedAt = orderedAt; }

    @Override
    public String toString() {
        return "Customer{id='" + id + "', firstName='" + firstName + "', lastName='" + lastName +
               "', emailAddress='" + emailAddress + "', phoneNumber='" + phoneNumber + "', orderDateTime='" + orderedAt + "'}";
    }
}
