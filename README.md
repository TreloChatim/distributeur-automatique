# Distributeur Automatique – API Java Spring Boot

Ce projet est une API REST simulant le fonctionnement d’un distributeur automatique. Elle a été développée en Java en utilisant le framework Spring Boot. L’objectif est de proposer une architecture modulaire, testable et conforme aux bonnes pratiques de développement.

## Objectifs

Le projet vise à :

- Gérer l’insertion de pièces de monnaie valides (MAD)
- Afficher la liste des produits disponibles et leur état d’accessibilité
- Permettre la sélection et l’achat de produits selon le solde inséré
- Gérer le rendu de monnaie de manière optimale
- Permettre l’annulation d’une transaction en cours

## Fonctionnalités principales

- Pièces acceptées : 0.5, 1, 2, 5, 10 MAD
- Rejet des pièces invalides
- Mise à jour dynamique du solde après insertion ou achat
- Affichage de l’état "achetable" des produits selon le solde disponible
- Ajout d’articles dans un panier temporaire
- Rendu de la monnaie restante après achat
- Annulation de la transaction avec remboursement du solde

## Technologies utilisées

- Java 17
- Spring Boot 3.2.3
- Maven (gestionnaire de dépendances)
- HTML/CSS/JavaScript (interface utilisateur moderne)

## Structure du projet

L’organisation du projet respecte une structure standard Spring Boot :
etude de cas/
├── pom.xml
├── src/
│ ├── main/
│ │ ├── java/com/distributeur/
│ │ │ ├── model/ → Classes métier : Produit, Piece, Panier, Distributeur
│ │ │ ├── controller/ → Contrôleur REST principal
│ │ │ └── DistributeurApplication.java
│ │ └── resources/
│ │ └── static/index.html → Interface graphique moderne
│ └── test/
│ └── java/com/distributeur/ → Tests unitaires

## Instructions d’exécution

Pour exécuter l’application en local :

1. Assurez-vous d'avoir Java 17 et Maven installés
2. Ouvrir un terminal dans le répertoire racine
3. Lancer les commandes suivantes :
```bash
mvn clean install
mvn spring-boot:run
```

L’application sera disponible à l’adresse suivante :  
http://localhost:8080/index.html

## Interface utilisateur

L'application dispose d'une interface graphique moderne permettant de :
- Insérer des pièces via des boutons interactifs
- Voir le catalogue des produits en temps réel
- Suivre le solde disponible
- Gérer le panier d'achat
- Rendre la monnaie ou annuler la transaction

## Tests

Des tests unitaires ont été mis en place pour valider les principaux cas d’usage, notamment :

- L’achat d’un produit avec rendu de monnaie
- L’ajout de plusieurs articles au panier
- L’annulation d’une transaction et le remboursement du solde

## Auteur

Bendani Hatim
Projet réalisé dans le cadre d’une étude de cas technique soumise pour une candidature de stage.
