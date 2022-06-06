package com.example.restaurantmanagement.repositories;

import com.example.restaurantmanagement.entities.Reservation;
import com.example.restaurantmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select r from Reservation r where r.table.id= :id and r.dateReservation= :dateReservation")
    Optional<Reservation> isEmptyForReservation(@Param("id") Long id, @Param("dateReservation") Date date);
}
