package com.example.restaurantmanagement.services;
import com.example.restaurantmanagement.entities.Categorie;
import com.example.restaurantmanagement.exceptions.CategorieNotFoundException;
import com.example.restaurantmanagement.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CategorieServiceImpl implements  CategorieService{

    private CategorieRepository categorieRepository;

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Long id, Categorie categorie) throws CategorieNotFoundException {
        return categorieRepository.findById(categorie.getId()).map(categorie1 -> {
            categorie1.setNom(categorie.getNom());
            categorie1.setDescritpion(categorie.getDescritpion());
            categorie1.setImage(categorie.getImage());
            categorie1.setRanking(categorie.getRanking());
            return categorieRepository.save(categorie1);
        }).orElseThrow(()-> new CategorieNotFoundException("Categorie Not Foundt") );
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public void deleteAllCategories() {
        categorieRepository.deleteAll();
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getCategorieById(Long id) throws CategorieNotFoundException {
        return categorieRepository.findById(id).orElseThrow(()-> new CategorieNotFoundException("Categorie not found"));
    }

    @Override
    public List<Categorie> getCategorieByNomContaining(String nom) {
        return categorieRepository.getCategoriesByNomContaining(nom);
    }

}
