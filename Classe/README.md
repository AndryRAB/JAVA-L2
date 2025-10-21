# Projet Java - Exercice 2

Ce projet contient la résolution de l'exercice 2. Il explore différentes manières de modéliser une classe d'étudiants en Java.

## Description de l'exercice

L'objectif de cet exercice est de créer une structure de données pour gérer des étudiants et leurs notes, puis de calculer des statistiques comme la moyenne des notes.

## Approches explorées

Le projet présente trois implémentations différentes, chacune dans sa propre classe :

### 1. `Classe.java`
Cette classe utilise un `HashMap<String, Integer>` pour stocker les notes des étudiants, où la clé est le nom de l'étudiant et la valeur est sa note.

### 2. `Classe2.java`
Cette approche utilise deux `HashMap` distincts : un pour les notes (`HashMap<String, Integer>`) et un autre pour les âges (`HashMap<String, Integer>`). Cette méthode est fonctionnelle mais peut être source d'erreurs si les deux maps ne sont pas synchronisées.

### 3. `Classe3.java` (et la classe `Etudiant`)
C'est l'approche la plus robuste et la plus orientée objet. Une classe `Etudiant` est créée pour encapsuler toutes les informations d'un étudiant (nom, âge, note). La classe `Classe3` utilise ensuite un `HashMap<String, Etudiant>` pour gérer l'ensemble des étudiants.

