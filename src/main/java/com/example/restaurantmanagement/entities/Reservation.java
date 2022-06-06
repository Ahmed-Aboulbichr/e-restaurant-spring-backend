package com.example.restaurantmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    private Date dateReservation;
    private int nbrPersonne;
    /*@OneToMany(mappedBy = "reservation")
    private List<Table> tables;*/

    /*@ManyToMany(mappedBy = "reservations")
    private List<User> users;*/
}
