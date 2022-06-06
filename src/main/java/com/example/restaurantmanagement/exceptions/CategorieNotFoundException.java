package com.example.restaurantmanagement.exceptions;

import java.util.function.Supplier;

public class CategorieNotFoundException extends  Exception {
    public CategorieNotFoundException(String categorie_not_foundt) {
        super(categorie_not_foundt);
    }

}
