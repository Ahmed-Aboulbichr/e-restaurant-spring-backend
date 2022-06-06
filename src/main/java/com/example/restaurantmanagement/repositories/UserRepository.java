package com.example.restaurantmanagement.repositories;

import com.example.restaurantmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from  User u  where  u.email = :email")
    Optional<User> getAuthenticatedUser(@Param("email") String email);

    Optional<User> findUserByNomContaining(String nom);
}
