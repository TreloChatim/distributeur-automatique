package com.distributeur;

import com.distributeur.model.Distributeur;
import com.distributeur.model.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistributeurApplicationTests {
    
    @Test
    public void testScenario1() {
        Distributeur distributeur = new Distributeur();
        
        // Insertion de 5 MAD
        assertTrue(distributeur.insererPiece(5.0));
        assertEquals(5.0, distributeur.getSolde());
        
        // Sélection d'un soda à 3.5 MAD
        assertTrue(distributeur.selectionnerProduit("SODA"));
        assertEquals(1.5, distributeur.getSolde());
        
        // Vérification du rendu de monnaie
        var monnaie = distributeur.rendreMonnaie();
        assertEquals(2, monnaie.size());
        assertEquals(1.0, monnaie.get(0).getValeur());
        assertEquals(0.5, monnaie.get(1).getValeur());
    }
    
    @Test
    public void testScenario2() {
        Distributeur distributeur = new Distributeur();
        
        // Insertion de 5 MAD + 2 MAD
        assertTrue(distributeur.insererPiece(5.0));
        assertTrue(distributeur.insererPiece(2.0));
        assertEquals(7.0, distributeur.getSolde());
        
        // Sélection soda 4.5 MAD + TikTak 2 MAD
        assertTrue(distributeur.selectionnerProduit("SODA"));
        assertTrue(distributeur.selectionnerProduit("TIKTAK"));
        assertEquals(0.5, distributeur.getSolde());
        
        // Vérification du rendu de monnaie
        var monnaie = distributeur.rendreMonnaie();
        assertEquals(1, monnaie.size());
        assertEquals(0.5, monnaie.get(0).getValeur());
    }
} 