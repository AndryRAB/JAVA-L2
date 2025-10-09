# Projet d'Infographie 2D en Java

Ce projet est une application graphique 2D simple et de géométrie analytique développée en Java. Il fournit des fonctionnalités de base pour dessiner des formes géométriques 2D dans un système de coordonnées personnalisé.

## Fonctionnalités

*   Dessiner des formes géométriques de base : `Point`, `Segment`, et `Courbe`.
*   Gérer un système de coordonnées personnalisé (`Repere`) et sa conversion en coordonnées écran (`CoordsEcr`).
*   Une interface `Dessinable` pour définir les objets pouvant être dessinés.
*   Une interface graphique simple pour afficher les dessins.

## Structure des Fichiers

*   `src/`: Contient le package de l'application.
    *   `infographie/`: Contient tous les fichiers source Java (`Main.java`, `Dessinable.java`, `Point.java`, etc.).
*   `bin/`: Contient les fichiers de classe (`.class`) Java compilés.
*   `readme.md`: Ce fichier.

## Comment Compiler et Exécuter

1.  **Compilation :**
    Ouvrez un terminal à la racine du projet et exécutez la commande suivante pour compiler les fichiers source dans le répertoire `bin` :
    ```bash
    javac -d bin src/infographie/*.java
    ```

2.  **Exécution :**
    Après la compilation, exécutez l'application avec cette commande :
    ```bash
    java -cp bin infographie.Main
    ```

## A faire

1. Essayer d'ajouter d'autres *éléments graphiques* 
2. Créer d'autres classes `Dessinable`
3. Implémenter les transformations géométriques sous forme de matrices
4. Implémenter les animations. 