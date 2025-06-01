package com.distributeur.model;

import lombok.Data;
import java.util.*;

@Data
public class Distributeur {
    private double solde;
    private Panier panier;
    private Map<String, Produit> catalogue;
    private List<Piece> piecesInserees;
    
    public Distributeur() {
        this.solde = 0.0;
        this.panier = new Panier();
        this.catalogue = new HashMap<>();
        this.piecesInserees = new ArrayList<>();
        initialiserCatalogue();
    }
    
    private void initialiserCatalogue() {
        catalogue.put("SODA", new Produit("SODA", "Soda", 3.5, 10));
        catalogue.put("TIKTAK", new Produit("TIKTAK", "TikTak", 2.0, 10));
        catalogue.put("CHIPS", new Produit("CHIPS", "Chips", 4.0, 10));
        catalogue.put("CHOCOLAT", new Produit("CHOCOLAT", "Chocolat", 5.0, 10));
    }
    
    public boolean insererPiece(double valeur) {
        if (!Piece.estValide(valeur)) {
            return false;
        }
        solde += valeur;
        piecesInserees.add(new Piece(valeur));
        return true;
    }
    
    public boolean selectionnerProduit(String idProduit) {
        Produit produit = catalogue.get(idProduit);
        if (produit == null || !produit.estDisponible() || solde < produit.getPrix()) {
            return false;
        }
        
        panier.ajouterProduit(produit);
        solde -= produit.getPrix();
        produit.decrementerQuantite();
        return true;
    }
    
    public List<Piece> rendreMonnaie() {
        List<Piece> monnaie = new ArrayList<>();
        double[] valeursPieces = {10.0, 5.0, 2.0, 1.0, 0.5};
        double reste = Math.round(solde * 100.0) / 100.0;
        for (double valeur : valeursPieces) {
            valeur = Math.round(valeur * 100.0) / 100.0;
            while (reste >= valeur - 0.001) { // tolérance pour les flottants
                monnaie.add(new Piece(valeur));
                reste -= valeur;
                reste = Math.round(reste * 100.0) / 100.0;
            }
        }
        solde = 0.0;
        return monnaie;
    }
    
    public void annulerTransaction() {
        solde = 0.0;
        panier.vider();
        piecesInserees.clear();
    }
    
    public List<Produit> getProduitsDisponibles() {
        return new ArrayList<>(catalogue.values());
    }
} 