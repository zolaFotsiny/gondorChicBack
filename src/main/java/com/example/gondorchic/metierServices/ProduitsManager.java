package com.example.gondorchic.metierServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gondorchic.definitions.Produit;

@Repository
public interface ProduitsManager extends JpaRepository<Produit, Integer>{
    
    @Query(value="SELECT * FROM T_produit WHERE estDuJour=true",nativeQuery = true)
    Produit[] rechercherProduitDuJour();
}

