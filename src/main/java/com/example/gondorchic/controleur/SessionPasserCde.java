package com.example.gondorchic.controleur;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gondorchic.metier.metierServices.ClientsManager;
import com.example.gondorchic.metier.metierServices.ProduitsManager;
import com.example.gondorchic.metier.modele.Client;
import com.example.gondorchic.metier.modele.EnumTypeEcran;
import com.example.gondorchic.metier.modele.Produit;

@RestController
@RequestMapping("api/v1")
public class SessionPasserCde {

    private EnumTypeEcran ecranCourant;
    private Produit leProduitCourant;
    private Client leClientIdentifie;

    @Autowired
    ProduitsManager produitsManager;

    @Autowired
    ClientsManager clientsManager;

    @CrossOrigin(origins = {"http://localhost:3000", "https://gondorchicfront.onrender.com"})
    @GetMapping("produits/produitsDuJour")
    public ResponseEntity<?> traiterAccesApplication() {
        ecranCourant = EnumTypeEcran.PAGE_ACCUEIL;
        leProduitCourant = produitsManager.rechercherProduitDuJour();
        
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("ecranCourant", ecranCourant);
        responseBody.put("leProduitCourant", leProduitCourant);
        return ResponseEntity.ok(responseBody);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://gondorchicfront.onrender.com"})
    @PostMapping("clients/connexion")
    public ResponseEntity<?> traiterIdentification(
        @RequestParam("pseudo") String pseudo,
        @RequestParam("motDePasse") String motDePasse
    ) {
        
        leClientIdentifie = clientsManager.rechercherClientParPseudo(pseudo, motDePasse);
        
        if (leClientIdentifie != null) {
            ecranCourant = EnumTypeEcran.PAGE_ACCUEIL_PERSO;
            leProduitCourant = produitsManager.rechercherProduitDuJour();
        } else {
            ecranCourant = EnumTypeEcran.PAGE_ACCUEIL;
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("ecranCourant", ecranCourant);
        responseBody.put("leClientIdentifie", leClientIdentifie);
        responseBody.put("leProduitCourant", leProduitCourant);
        return ResponseEntity.ok(responseBody);
    }
}
