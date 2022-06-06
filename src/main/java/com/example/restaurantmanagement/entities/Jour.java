package com.example.restaurantmanagement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Jour {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;

    /*@OneToMany(mappedBy = "platDuJour")
    private List<Plat> plats;*/

    @ManyToMany
    @JoinTable(
            name = "plat_du_jour",
            joinColumns = @JoinColumn(name = "jour_id"),
            inverseJoinColumns = @JoinColumn(name = "plat_id")
    )
    Set<Plat> plats;

}
