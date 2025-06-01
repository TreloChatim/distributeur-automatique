package com.distributeur.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Panier {
    private List<Produit> produits;
    private double montantTotal;
    
    public Panier() {
        this.produits = new ArrayList<>();
        this.montantTotal = 0.0;
    }
    
    public void ajouterProduit(Produit produit) {
        produits.add(produit);
        montantTotal += produit.getPrix();
    }
    
    public void vider() {
        produits.clear();
        montantTotal = 0.0;
    }
    
    public boolean estVide() {
        return produits.isEmpty();
    }
} 