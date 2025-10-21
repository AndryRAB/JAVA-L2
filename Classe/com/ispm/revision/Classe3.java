package com.ispm.revision;

import java.util.HashMap;
// créer une classe Etudiant pour encapsuler nom, âge et note, puis utiliser un HashMap<String, Etudiant> dans la classe Classe3
// pour gérer les étudiants de manière plus cohérente et éviter les erreurs d'association
// c'est plus conforme aux principes de la POO

class Etudiant {
    private String nom;
    private int age;
    private int note; //en pratique, ce serait mieux d'utiliser un float pour les notes

    public Etudiant(String nom, int age, int note) {
        this.nom = nom;
        this.age = age;
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public int getNote() {
        return note;
    }
}

public class Classe3 {
    private HashMap<String, Etudiant> etudiants;

    public Classe3() {
        etudiants = new HashMap<>();
    }

    public void ajouterEtudiant(String nom, int age, int note) {
        Etudiant etudiant = new Etudiant(nom, age, note);
        etudiants.put(nom, etudiant);
    }
    public Etudiant getEtudiant(String nom) {
        return etudiants.get(nom);
    }

    public double getMoyenne() {
        if (etudiants.isEmpty()) {
            return 0.0;
        }
        int somme = 0;
        for (Etudiant e : etudiants.values()) {
            somme += e.getNote();
        }
        return (double) somme / etudiants.size();
    }   

    public double getMoyenneAge() {
        if (etudiants.isEmpty()) {
            return 0.0;
        }
        int somme = 0;
        for (Etudiant e : etudiants.values()) {
            somme += e.getAge();
        }
        return (double) somme / etudiants.size();
    }
}