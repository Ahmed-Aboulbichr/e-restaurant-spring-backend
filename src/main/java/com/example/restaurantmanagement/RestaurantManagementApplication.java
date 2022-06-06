package com.example.restaurantmanagement;

import com.example.restaurantmanagement.entities.Categorie;
import com.example.restaurantmanagement.entities.Plat;
import com.example.restaurantmanagement.entities.User;
import com.example.restaurantmanagement.repositories.CategorieRepository;
import com.example.restaurantmanagement.repositories.UserRepository;
import com.example.restaurantmanagement.services.CategorieService;
import com.example.restaurantmanagement.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Slf4j
public class RestaurantManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CategorieService categorieService){
        return  args -> {
            Stream.of("PETIT DÉJEUNER À LA CARTE",
                    "CRÊPES SALÉES",
                    "ENTRÉES",
                    "SALADES GOURMANDES",
                    "PÂTES",
                    "PIZZAS").forEach(s -> {
                Categorie categorie =new Categorie();
                categorie.setNom(s);
                categorie.setRanking((int) Math.round(Math.random() * 10));
                categorie.setDescritpion(s+ UUID.randomUUID());
                categorieService.createCategorie(categorie);
            });

        };
    }

    //@Bean
    CommandLineRunner runner(UserService userService){
        return  args -> {
            userService.getUsers().forEach(user -> {
                log.info(user.toString());
            });
        };
    }
    //@Bean
    CommandLineRunner start(UserRepository userRepository){
        return args -> {
            Stream.of("Ahmed", "Marouane","Mahmoud").forEach(name -> {
                User user = new User();
                user.setNom(name);
                user.setEmail(name+"@gmail.com");
                user.setPassword("PAss"+name);
                user.setPhone((Math.random() * 100000000)+"");
                userRepository.save(user);
            });

        };
    }

}
