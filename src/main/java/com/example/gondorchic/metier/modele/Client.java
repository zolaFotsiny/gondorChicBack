package com.example.gondorchic.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "numero")
    private String numero;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "motDePasse")
    private String motDePasse;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;
}
