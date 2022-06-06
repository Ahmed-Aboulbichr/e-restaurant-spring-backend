package com.example.restaurantmanagement.repositories;

import com.example.restaurantmanagement.entities.Table;
import com.example.restaurantmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
