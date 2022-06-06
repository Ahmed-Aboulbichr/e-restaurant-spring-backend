package com.example.restaurantmanagement.services;

import com.example.restaurantmanagement.entities.Categorie;
import com.example.restaurantmanagement.exceptions.CategorieNotFoundException;

import java.util.List;

public interface CategorieService {

    Categorie createCategorie(Categorie categorie);
    Categorie updateCategorie(Long id, Categorie categorie) throws CategorieNotFoundException;
    void deleteCategorie(Long id);
    void deleteAllCategories();

    List<Categorie> getAllCategories();

    Categorie getCategorieById(Long id) throws CategorieNotFoundException;

    List<Categorie> getCategorieByNomContaining(String nom);


}
