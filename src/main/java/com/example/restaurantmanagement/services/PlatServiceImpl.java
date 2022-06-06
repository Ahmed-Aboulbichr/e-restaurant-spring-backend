package com.example.restaurantmanagement.services;

import com.example.restaurantmanagement.entities.Plat;
import com.example.restaurantmanagement.exceptions.CategorieNotFoundException;
import com.example.restaurantmanagement.exceptions.PlatNotFoundException;
import com.example.restaurantmanagement.repositories.CategorieRepository;
import com.example.restaurantmanagement.repositories.PlatRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PlatServiceImpl implements  PlatService{

    private PlatRepository platRepository;
    private CategorieRepository categorieRepository;

    @Override
    public Plat createPlat(Long id, Plat plat) throws CategorieNotFoundException {
        return categorieRepository.findById(id).map(categorie -> {
            plat.setCategorie(categorie);
            return platRepository.save(plat);
        }).orElseThrow(() -> new CategorieNotFoundException("Cattegorie not found"));
    }

    @Override
    public Plat updatePlat(Plat plat){
        return platRepository.save(plat);
    }

    @Override
    public void deletePlat(Long plat_id,Long categorie_id) {
        Plat plat = platRepository.findPlatByIdAndCategorie_Id(plat_id, categorie_id);
        platRepository.delete(plat);
    }

    @Override
    public void deleteAllPlats() {
        platRepository.deleteAll();
    }

    @Override
    public List<Plat> getPlatsByCategorie_id(Long categorie_id) {
        return platRepository.findPlatsByCategorie_Id(categorie_id);
    }

    @Override
    public Plat getPlatById(Long id) throws PlatNotFoundException {
        return platRepository.findById(id).orElseThrow(()-> new PlatNotFoundException("Plat not found"));
    }

    @Override
    public List<Plat> getPlatsByNomContaining(String nom) {
        return platRepository.getPlatsByNomContaining(nom);
    }

    @Override
    public List<Plat> getPlatsByPrixBetween(double begin, double end) {
        return platRepository.getPlatsByPrixBetween(begin, end);
    }

}
