package com.example.restaurantmanagement.exceptions;

import java.util.function.Supplier;

public class TableNotFoundException extends Exception{
    public TableNotFoundException(String s) {
        super(s);
    }
}
