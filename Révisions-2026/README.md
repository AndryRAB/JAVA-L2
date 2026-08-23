# Exercices de révision Java — codes de référence (ISPM, L2 Informatique)

Tous les fichiers compilent et s'exécutent sous **Java 21**.

## Programme récapitulatif

    java Solution.java

Fichier unique et autonome (aucune compilation préalable) : il rejoue, section par
section, toutes les sorties reproduites dans le corrigé.

## Fichiers séparés

| Fichier | Contenu |
|---|---|
| `Smartphone.java` | Exercice 2 — classe complète, `compareTo` « plus récent d'abord » |
| `Livre.java` | Exercice 3 — code, titre, auteur |
| `Bibliotheque.java` | Exercice 3 — double indexation (index principal + index inversé) |
| `BoiteObjet.java` | Exercice 1.2.a version A — lève une `ClassCastException` à l'exécution |
| `erreurs/BoiteGenerique.java` | Exercice 1.2.a version B — **ne compile pas**, c'est le résultat attendu |
| `Lambda.java` | Exercice 1.2.b et 1.2.c — classe anonyme, lambda, `Comparator` |
| `BoucleEtPipeline.java` | Exercice 1.2.d — la même `Map` par une boucle puis par un pipeline |

Compilation des fichiers séparés :

    javac *.java && java Lambda

Le fichier `erreurs/BoiteGenerique.java` est isolé exprès : il doit produire

    error: incompatible types: String cannot be converted to Integer
