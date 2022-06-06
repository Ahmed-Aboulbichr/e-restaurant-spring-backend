package com.example.restaurantmanagement.services;

import com.example.restaurantmanagement.entities.Plat;
import com.example.restaurantmanagement.exceptions.CategorieNotFoundException;
import com.example.restaurantmanagement.exceptions.PlatNotFoundException;

import java.util.List;

public interface PlatService {

    Plat createPlat(Long id,Plat plat) throws CategorieNotFoundException;

    Plat updatePlat(Plat plat);

    void deletePlat(Long plat_id,Long categorie_id);

    void deleteAllPlats();

    List<Plat> getPlatsByCategorie_id(Long categorie_id);

    Plat getPlatById(Long id) throws PlatNotFoundException;

    List<Plat> getPlatsByNomContaining(String nom);

    List<Plat> getPlatsByPrixBetween(double begin, double end);


}
