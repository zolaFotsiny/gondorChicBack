package com.example.gondorchic.metier.metierServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gondorchic.metier.modele.Client;

@Repository
public interface ClientsManager extends JpaRepository<Client, Integer>{
    
    @Query(value="SELECT * FROM T_client WHERE pseudo = :pseudo AND motDePasse = :motDePasse", nativeQuery = true)
    Client rechercherClientParPseudo(@Param("pseudo") String pseudo, @Param("motDePasse") String motDePasse);
}

