package com.example.restaurantmanagement.web;

import com.example.restaurantmanagement.entities.Plat;
import com.example.restaurantmanagement.exceptions.CategorieNotFoundException;
import com.example.restaurantmanagement.exceptions.PlatNotFoundException;
import com.example.restaurantmanagement.services.PlatService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class PlatRestApi {

    private PlatService platService;

    @PostMapping("/categories/{id}/plats")
    public ResponseEntity<Plat> createPlat(@PathVariable Long id ,@Valid @RequestBody Plat plat) throws CategorieNotFoundException {
        return ResponseEntity.ok(platService.createPlat(id,plat));
    }

    @PutMapping("/plats")
    public ResponseEntity<Plat> updatePlat(@Valid @RequestBody Plat plat){
        return ResponseEntity.ok(platService.updatePlat(plat));
    }

    @DeleteMapping("/categories/{categorie_id}/plats/{plat_id}")
    public ResponseEntity<?> deletePlat(@PathVariable(value = "plat_id") Long plat_id,@PathVariable(value = "categorie_id") Long categorie_id) {
        platService.deletePlat(plat_id, categorie_id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/plats")
    public void deleteAllPlats() {
        platService.deleteAllPlats();
    }

    @GetMapping("/categories/{categorie_id}/plats")
    public ResponseEntity<List<Plat>> getPlatsByCategorie_id(@PathVariable Long categorie_id) {
        return ResponseEntity.ok(platService.getPlatsByCategorie_id(categorie_id));
    }

    @GetMapping("/plats/{id}")
    public ResponseEntity<Plat> getPlatById(@PathVariable Long id) throws PlatNotFoundException {
        return ResponseEntity.ok(platService.getPlatById(id));
    }

    @GetMapping("/platsbyname/{nom}")
    public ResponseEntity<List<Plat>> getPlatsByNomContaining(@PathVariable String nom) {
        return ResponseEntity.ok(platService.getPlatsByNomContaining(nom));
    }

    @GetMapping("plats/{begin}/{end}")
    public ResponseEntity<List<Plat>> getPlatsByPrixBetween(@PathVariable double begin,@PathVariable double end) {
        return ResponseEntity.ok(platService.getPlatsByPrixBetween(begin, end));
    }
}
