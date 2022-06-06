package com.example.restaurantmanagement.web;

import com.example.restaurantmanagement.entities.Categorie;
import com.example.restaurantmanagement.exceptions.CategorieNotFoundException;
import com.example.restaurantmanagement.services.CategorieServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class CategorieRestApi {

    private CategorieServiceImpl categorieService;

    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAllCategorie(){
        List<Categorie> categorieList = categorieService.getAllCategories();
        if(categorieList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorieList, HttpStatus.OK);
    }

    @GetMapping("/categorie/{id}")
    public Categorie getCategorieById(@PathVariable Long id) throws CategorieNotFoundException {
        return categorieService.getCategorieById(id);
    }

    @GetMapping("/categories/{nom}")
    public ResponseEntity<List<Categorie>> getCategoriesByNomContaining(@PathVariable String nom){
        return new ResponseEntity<>(categorieService.getCategorieByNomContaining(nom), HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie){
        return new ResponseEntity<>(categorieService.createCategorie(categorie), HttpStatus.OK);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable Long id, @RequestBody Categorie categorie) throws CategorieNotFoundException {
        return new ResponseEntity<>(categorieService.updateCategorie(id, categorie), HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<HttpStatus> deleteCategorie(@PathVariable Long id){
        categorieService.deleteCategorie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/categories")
    public ResponseEntity<HttpStatus> deleteCategorie(){
        categorieService.deleteAllCategories();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
