package com.example.gondorchic.metierServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gondorchic.definitions.Produit;

@Repository
public interface ProduitsManager extends JpaRepository<Produit, String>{
    
    @org.springframework.data.jpa.repository.Query(value="select * from t_produit where estDuJour=true",nativeQuery = true)
    Produit rechercherProduitDuJour();
}

