package com.example.restaurantmanagement.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String user_not_found) {
        super(user_not_found);
    }
}
