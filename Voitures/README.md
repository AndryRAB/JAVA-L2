# Projet Java - Exercice sur les Voitures

Ce projet a été réalisé dans le cadre d'un exercice de Java (L2). L'objectif est de créer une classe `Voiture` et d'utiliser une `PriorityQueue` pour les trier en fonction de différents critères.

## Exercice 1 : Application de la classe File de Priorité

L'exercice consistait à :

1.  **Créer une classe `Voiture`** implémentant `Comparable<Voiture>` avec les attributs suivants :
    *   `Marque`
    *   `Vitesse Max`
    *   `Poids`
    *   `Nombre de places`
    *   `Année de sortie`
    La classe doit aussi contenir une redéfinition de `toString()` et une méthode `compareTo(Voiture autre)` qui donne la priorité aux voitures les plus récentes.

2.  **Dresser le diagramme de classes** de la classe `Voiture`.

3.  **Proposer d'autres implémentations** pour `compareTo()` afin de changer les critères de priorité :
    a. Ordre alphabétique des marques.
    b. Priorité aux voitures avec le plus de places, puis les plus rapides.
    c. Priorité aux voitures avec le plus de places, puis les plus rapides, puis les plus récentes.

## Fichiers du Projet

*   `Voiture.java`: Contient la définition de la classe `Voiture`.
    *   Elle implémente `Comparable<Voiture>` et la méthode `compareTo` pour trier les voitures par année de sortie (la plus récente en premier).
    *   Les autres logiques de comparaison de la question 3 sont incluses en tant que commentaires.
*   `Main.java`: Contient le programme principal pour tester la `PriorityQueue`.
    *   Il crée plusieurs instances de `Voiture`.
    *   Il les ajoute à une `PriorityQueue` pour démontrer le tri par défaut (basé sur l'année).
    *   Il montre également comment utiliser des `Comparator` (via une classe anonyme et une expression lambda) pour appliquer les autres règles de tri sans modifier le code de la classe `Voiture`.
*   `JAVA - L2 - 01.pdf`: Le sujet de l'exercice.

## Comment compiler et exécuter

1.  **Compiler les classes Java :**
    ```sh
    javac Voiture.java Main.java
    ```

2.  **Exécuter le programme principal :**
    ```sh
    java Main
    ```

### Résultat Attendu

Le programme affichera les listes de voitures triées selon les différents critères de priorité définis dans `Main.java`.
