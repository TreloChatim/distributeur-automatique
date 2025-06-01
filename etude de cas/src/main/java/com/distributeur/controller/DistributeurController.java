package com.distributeur.controller;

import com.distributeur.model.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/distributeur")
public class DistributeurController {
    private final Distributeur distributeur;
    
    public DistributeurController() {
        this.distributeur = new Distributeur();
    }
    
    @PostMapping("/pieces")
    public boolean insererPiece(@RequestParam double valeur) {
        return distributeur.insererPiece(valeur);
    }
    
    @GetMapping("/produits")
    public List<Produit> getProduits() {
        return distributeur.getProduitsDisponibles();
    }
    
    @PostMapping("/produits/{id}")
    public boolean selectionnerProduit(@PathVariable String id) {
        return distributeur.selectionnerProduit(id);
    }
    
    @GetMapping("/solde")
    public double getSolde() {
        return distributeur.getSolde();
    }
    
    @GetMapping("/panier")
    public Panier getPanier() {
        return distributeur.getPanier();
    }
    
    @PostMapping("/monnaie")
    public List<Piece> rendreMonnaie() {
        return distributeur.rendreMonnaie();
    }
    
    @PostMapping("/annuler")
    public void annulerTransaction() {
        distributeur.annulerTransaction();
    }
} 