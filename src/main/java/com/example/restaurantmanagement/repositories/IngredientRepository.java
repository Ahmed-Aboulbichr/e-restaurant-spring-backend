package com.example.restaurantmanagement.repositories;

import com.example.restaurantmanagement.entities.Ingredient;
import com.example.restaurantmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
