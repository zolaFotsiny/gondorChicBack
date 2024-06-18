package com.example.gondorchic.metier.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Produit")
@Table(name = "t_produit")
@Data
public class Produit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "reference")
    private String reference;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "estdujour")
    private boolean estDuJour;

    @Column(name = "prix")
    private float prix;

    @Column(name = "quantiteenstock")
    private int quantiteEnStock;
}
