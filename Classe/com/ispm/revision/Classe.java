package com.ispm.revision;

import java.util.HashMap;

public class Classe {
    private HashMap<String, Integer> note; //en pratique, ce serait mieux d'utiliser un HashMap<String, Float> pour les notes

    public Classe() {
        note = new HashMap<>();
    }

    public void ajouterNote(String nom, int note) { //Partie A - 5)
        this.note.put(nom, note);
    }

    public int getNote(String nom) { //Partie A - 6)
        return this.note.getOrDefault(nom, -1);
    }

    public double getMoyenne() { //Partie A - 7)
        if (note.isEmpty()) {
            return 0.0;
        }
        int somme = 0;
        for (int n : note.values()) { // Toutes les valeurs de note dans la HashMap
            somme += n;
        }
        return (double) somme / note.size();
    }   

}