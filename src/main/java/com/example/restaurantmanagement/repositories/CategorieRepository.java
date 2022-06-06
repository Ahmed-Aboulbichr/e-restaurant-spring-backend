package com.example.restaurantmanagement.repositories;

import com.example.restaurantmanagement.entities.Categorie;
import com.example.restaurantmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    List<Categorie> getCategoriesByNomContaining(String param);
}
