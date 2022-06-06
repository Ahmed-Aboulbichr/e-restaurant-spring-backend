package com.example.restaurantmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Plat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;
    private String image;
    private String description;
    private double prix;
    private int ranking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categorie_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Categorie categorie;

    /*@OneToMany(mappedBy = "plat")
    private List<Ingredient> ingredients ;*/

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "")
    private PlatDuJour platDuJour;*/

    @ManyToMany(mappedBy = "plats")
    Set<Jour> platDuJours;


}
