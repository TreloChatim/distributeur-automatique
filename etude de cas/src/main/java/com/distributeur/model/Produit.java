package com.distributeur.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    private String id;
    private String nom;
    private double prix;
    private int quantite;
    
    public boolean estDisponible() {
        return quantite > 0;
    }
    
    public void decrementerQuantite() {
        if (quantite > 0) {
            quantite--;
        }
    }
} 