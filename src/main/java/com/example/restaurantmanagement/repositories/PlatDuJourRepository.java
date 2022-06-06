package com.example.restaurantmanagement.repositories;

import com.example.restaurantmanagement.entities.Jour;
import com.example.restaurantmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatDuJourRepository extends JpaRepository<Jour, Long> {
}
