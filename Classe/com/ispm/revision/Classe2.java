package com.ispm.revision;

import java.util.HashMap;

public class Classe2 { // Partie B - 8)

    // un hashmap pour les notes et un autre pour les âges, ça peut marcher mais c'est pas optimal
    // et il faut être très strict dans l'encapsulation pour éviter les erreurs
    
    private HashMap<String, Integer> note;
    private HashMap<String, Integer> age; 

    public Classe2() {
        note = new HashMap<>();
        age = new HashMap<>();
    }

    public void ajouterNote(String nom, int note) {
        this.note.put(nom, note);
    }

    public void ajouterAge(String nom, int age) {
        this.age.put(nom, age);
    }
    public int getNote(String nom) {
        return this.note.getOrDefault(nom, -1);
    }

    public int getAge(String nom) {
        return this.age.getOrDefault(nom, -1);
    }

    public double getMoyenne() {
        return note.values().stream().mapToInt(Integer::intValue).average().orElse(0.0); /// utilisation de streams pour simplifier le calcul de la moyenne
    }

    public double getMoyenneAge() { // Partie B - 9)
       return age.values().stream().mapToInt(Integer::intValue).average().orElse(0.0); /// utilisation de streams pour simplifier le calcul de la moyenne
    }   


}