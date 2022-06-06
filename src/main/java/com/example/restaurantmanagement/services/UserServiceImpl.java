package com.example.restaurantmanagement.services;

import com.example.restaurantmanagement.entities.Reservation;
import com.example.restaurantmanagement.entities.Table;
import com.example.restaurantmanagement.entities.User;
import com.example.restaurantmanagement.exceptions.UserNotFoundException;
import com.example.restaurantmanagement.exceptions.isReservedException;
import com.example.restaurantmanagement.repositories.ReservationRepository;
import com.example.restaurantmanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
//@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private ReservationRepository reservationRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ReservationRepository reservationRepository){
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User addUser(User user) {
        log.info("L'insertion d'utilisateur : "+user.getNom());
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User user1 = userRepository.save(user);
        log.info("Insertion du "+user1.getNom()+" ("+user.getId()+") est bien validé ");
        return user1;
    }

    @Override
    public List<User> getUsers() {
        log.info("La liste des utilisateurs");
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if ( user ==  null) throw  new UserNotFoundException("User Not Found");
        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User isUser(String email, String password) {
        User user = userRepository.getAuthenticatedUser(email).orElse(null);
        if(user == null){
            return null;
        }

        if(this.passwordEncoder.matches(password, user.getPassword())){
            return user;
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getReservations(User user) throws UserNotFoundException {
        return userRepository.findById(user.getId()).map(user1 -> {
            return user1.getReservations();
        }).orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }

    @Override
    public Reservation reserver(User user, Table table, Date dateReservation) throws isReservedException {

        Reservation reservation = reservationRepository.isEmptyForReservation(table.getId(), dateReservation).orElse(null);
        if(reservation == null){
            throw  new isReservedException("Table is reserved");
        }
        reservation.setUser(user);
        reservation.setDateReservation(dateReservation);
        reservation.setTable(table);
        return reservationRepository.save(reservation);
    }
}
