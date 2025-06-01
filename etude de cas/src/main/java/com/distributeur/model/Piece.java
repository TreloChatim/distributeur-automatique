package com.distributeur.model;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Piece {
    private double valeur;
    
    public static boolean estValide(double valeur) {
        return valeur == 0.5 || valeur == 1.0 || valeur == 2.0 || 
               valeur == 5.0 || valeur == 10.0;
    }
} 