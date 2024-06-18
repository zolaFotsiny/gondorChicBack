package com.example.gondorchic.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gondorchic.metier.metierServices.ClientsManager;
import com.example.gondorchic.metier.modele.Client;

@RestController
@RequestMapping("api/v1/clients")
public class ClientsControleur {
    
    @Autowired
    ClientsManager clientsManager;

    @CrossOrigin(origins = {"http://localhost:3000", "https://gondorchicfront.onrender.com"})
    @PostMapping("/connexion")
    public ResponseEntity<Client> rechercherClientParPseudo(
            @RequestParam("pseudo") String pseudo,
            @RequestParam("motDePasse") String motDePasse) {
        
        Client client = clientsManager.rechercherClientParPseudo(pseudo, motDePasse);
        
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
