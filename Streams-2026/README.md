# Streams-2026

Corrigés des exercices « Des interfaces aux Streams API » — ISPM, L2 Informatique,
année universitaire 2025–2026.

Chaque `ExerciceN.java` est autonome (une classe, une méthode `main`) et
correspond à la question du même numéro dans l'énoncé. Les jeux de données
utilisent des noms malgaches (Rakoto, Rabe, Rajaonarivelo, Rasoa, Miora,
Antso, Koloina...).

## Contenu

| Fichier | Sujet |
|---|---|
| `Exercice1.java` | Interface fonctionnelle `Operation` + lambdas (addition, soustraction, multiplication, maximum) |
| `Exercice2.java` | Streams sur une liste de noms : `filter`, `map`, `sorted`, `count` |
| `Exercice3.java` | Streams sur une liste de notes : `average`, `max`, tri décroissant |
| `Exercice4.java` | Classe `Produit` (record) : `Collectors.groupingBy`, prix moyen, produit le plus cher |
| `Exercice5.java` | Classe `Etudiant` (record) : `Collectors.partitioningBy` (admis/non admis), `groupingBy` par niveau, meilleur étudiant |

## Compilation et exécution

Java 17 ou supérieur (utilisation de `record`).

```bash
javac ExerciceN.java
java ExerciceN
```

## Contraintes respectées

- Une seule classe par exercice, une méthode `main`.
- Aucune boucle `for`/`while` là où un Stream fait le travail.
- Aucun `Optional[...]` laissé à l'affichage (`orElse` / `ifPresent` systématiques).
- Aucun `Stream` stocké dans une variable puis réutilisé (un `.stream()` par pipeline).
- Exercice 5 : admis et non admis obtenus par un seul `partitioningBy`.

Toutes les sorties ont été vérifiées par compilation et exécution réelles
(`javac` + `java`), pas reconstituées.

## Document lié

Corrigé complet au format PDF (avec explications, pièges classiques et
sorties console) : voir le document ISPM « Corrigé — Interfaces et Streams ».
