package com.ispm.revision;

public class Main {
    public static void main(String[] args) {
        Classe c = new Classe();
        c.ajouterNote("Alice", 15);
        c.ajouterNote("Bob", 12);
        System.out.println("Note d'Alice: " + c.getNote("Alice")); // 15
        System.out.println("Moyenne: " + c.getMoyenne()); // 13.5

        Classe2 c2 = new Classe2();
        c2.ajouterNote("Alice", 15);
        c2.ajouterAge("Alice", 20);
        c2.ajouterNote("Bob", 12);
        c2.ajouterAge("Bob", 22);
        System.out.println("Note de Bob: " + c2.getNote("Bob")); // 12
        System.out.println("Âge de Bob: " + c2.getAge("Bob")); // 22
        System.out.println("Moyenne des notes: " + c2.getMoyenne()); // 13.5
        System.out.println("Moyenne des âges: " + c2.getMoyenneAge()); // 21.0

        Classe3 c3 = new Classe3();
        c3.ajouterEtudiant("Alice", 20, 15);
        c3.ajouterEtudiant("Bob", 22, 12);
        System.out.println("Note d'Alice: " + c3.getEtudiant("Alice").getNote()); // 15
        System.out.println("Âge de Bob: " + c3.getEtudiant("Bob").getAge()); // 22
        System.out.println("Moyenne des notes: " + c3.getMoyenne()); // 13.5
        System.out.println("Moyenne des âges: " + c3.getMoyenneAge()); // 21.0
    }
}