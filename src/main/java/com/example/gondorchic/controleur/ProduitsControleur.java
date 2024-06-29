package com.example.gondorchic.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gondorchic.metier.metierServices.ProduitsManager;
import com.example.gondorchic.metier.modele.Produit;

@RestController
@RequestMapping("api/v1/produits")
public class ProduitsControleur {
    
    @Autowired
    ProduitsManager produitsManager;
    @GetMapping("/produitsDuJour")
    public ResponseEntity<Produit> rechercherProduitDuJour() {
        return new ResponseEntity<>(produitsManager.rechercherProduitDuJour(), HttpStatus.OK);
    }
}
