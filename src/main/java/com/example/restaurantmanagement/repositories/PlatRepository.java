package com.example.restaurantmanagement.repositories;

import com.example.restaurantmanagement.entities.Plat;
import com.example.restaurantmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatRepository extends JpaRepository<Plat, Long> {

    List<Plat> getPlatsByNomContaining(String nom);

    List<Plat> getPlatsByPrixBetween(double begin, double end);

    Plat findPlatByIdAndCategorie_Id(Long plat_id, Long categorie_id);

    List<Plat> findPlatsByCategorie_Id(Long categorieId);

}
