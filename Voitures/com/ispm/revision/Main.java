package com.ispm.revision;


import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Voiture voiture1 = new Voiture("Toyota", 180, 1500, 5, 2020);
        Voiture voiture2 = new Voiture("Ford", 200, 1600, 4, 2018);
        Voiture voiture3 = new Voiture("BMW", 250, 1700, 5, 2021);

        ArrayList<Voiture> voitures = new ArrayList<Voiture>();
        voitures.add(voiture1);
        voitures.add(voiture2);
        voitures.add(voiture3);



        PriorityQueue<Voiture> filePriorite = new PriorityQueue<>();
        filePriorite.add(voiture1); 
        filePriorite.add(voiture2);
        filePriorite.add(voiture3);

        System.out.println("Voitures dans la file de priorité :");
        while (!filePriorite.isEmpty()) {
            System.out.println(filePriorite.poll());
        }

        // **BONUS** : Les autres versions de compareTo (Question 3) sont présentés ici en utilisant les Comparators. Sans 'toucher' à la classe `Voiture`. Juste en créant une classe anonyme implémentant Comparator<Voiture>.

        PriorityQueue<Voiture> filePriorite2 = new PriorityQueue<>(new Comparator<Voiture>() { //Question 3.c
            @Override
            public int compare(Voiture a, Voiture b) {
                int c = b.getNombreDePlaces() - a.getNombreDePlaces();
                if (c!=0) return c;
                c = b.getVitesseMax() - a.getVitesseMax();
                if (c!=0) return c;
                return b.getAnneeDeSortie() - a.getAnneeDeSortie();
            }
        });

        filePriorite2.addAll(voitures);

        System.out.println("Voitures dans la file de priorité : règle 3.c");
        while (!filePriorite2.isEmpty()) {
            System.out.println(filePriorite2.poll());
        }
        
        PriorityQueue<Voiture> filePriorite3 = new PriorityQueue<>((a, b) -> a.getMarque().compareTo(b.getMarque())); //Question 3.a, on utilise une expression lambda pour créer le Comparator de manière plus concise. Mais c'est la même chose que la classe anonyme.
        filePriorite3.addAll(voitures);                

        System.out.println("Voitures dans la file de priorité : règle 3.a");
        while (!filePriorite3.isEmpty()) {
            System.out.println(filePriorite3.poll());
        }
    }
}
