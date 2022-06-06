package com.example.restaurantmanagement.services;

import com.example.restaurantmanagement.entities.Reservation;
import com.example.restaurantmanagement.entities.Table;
import com.example.restaurantmanagement.entities.User;
import com.example.restaurantmanagement.exceptions.UserNotFoundException;
import com.example.restaurantmanagement.exceptions.isReservedException;

import java.util.Date;
import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getUsers();

    User getUser(Long id) throws UserNotFoundException;

    User updateUser(User user);

    User isUser(String email, String password);

    void deleteUser(Long id);

    List<Reservation> getReservations(User user) throws UserNotFoundException;

    Reservation reserver(User user, Table table, Date dateReservation) throws isReservedException;
}
