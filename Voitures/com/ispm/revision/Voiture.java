
package com.ispm.revision;



public class Voiture implements Comparable<Voiture> {
    private String marque;
    private int vitesseMax;
    private int poids;
    private int nombreDePlaces;
    private int anneeDeSortie;

    
    //Constructeur

    public Voiture(String marque, int vitesseMax, int poids, int nombreDePlaces, int anneeDeSortie) {
        this.marque = marque;
        this.vitesseMax = vitesseMax;
        this.poids = poids;
        this.nombreDePlaces = nombreDePlaces;
        this.anneeDeSortie = anneeDeSortie;
    }

    //getters

    public String getMarque() {
        return marque;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public int getPoids() {
        return poids;
    }

    public int getNombreDePlaces() {
        return nombreDePlaces;
    }
    
    public int getAnneeDeSortie() {
        return anneeDeSortie;
    }

    //Quelques méthodes supplémentaires

    public boolean estPlusRapideQue(Voiture autreVoiture) {
        return this.vitesseMax > autreVoiture.vitesseMax;
    }

    public boolean peutTransporter(int nombreDePersonnes) {
        return nombreDePersonnes <= this.nombreDePlaces;
    }

    public int ageDeLaVoiture() {
        return 2025 - this.anneeDeSortie; // en supposant que l'année actuelle est 2025, on peut aussi utiliser LocalDate.now().getYear()
    }

    //redéfinition de toString et compareTo
    @Override 
    public String toString() {
        return marque + ", " + nombreDePlaces + " places, " + vitesseMax + " km/h, " + poids + " kg, sortie en " + anneeDeSortie;
    }

    //on compare this à autre, 
    //on retourne une valeur <0 si this est prioritaire par rapport à autre 
    //on retourne une valeur >0 si autre est prioritaire par rapport à this 
    //on retourne la valeur 0 sinon 
    @Override
    public int compareTo(Voiture autreVoiture) { // priorité aux voitures les plus récentes
        return  autreVoiture.anneeDeSortie - this.anneeDeSortie;
    }
    
    // versions alternatives (Question 3), décommenter la version voulue et commenter les autres
    /*
    a.  Ordre alphabétique sur la marque
    */
    /*
    @Override
    public int compareTo(Voiture autreVoiture) {
        return this.marque.compareTo(autreVoiture.marque);
    }
    */
    /*
    b.  Priorité aux voitures ayant le plus grand nombre de places. Si deux voitures ont le même nombre 
        de places, donner la priorité à la voiture la plus rapide.  
    */
    /*/
    @Override
    public int compareTo(Voiture autreVoiture) {
        int c = autreVoiture.nombreDePlaces - this.nombreDePlaces;
        if (c!=0) return c;
        return autreVoiture.vitesseMax - this.vitesseMax;
    }
    /*
    c.  Même règle que b. Mais si les voitures ont la même vitesse max et le même nombre de places, 
        donner la priorité à la voiture la plus récente. 
    */
    /*

    @Override
    public int compareTo(Voiture autreVoiture) {
        int c = autreVoiture.nombreDePlaces - this.nombreDePlaces;
        if (c!=0) return c;
        c = autreVoiture.vitesseMax - this.vitesseMax;
        if (c!=0) return c;
        return autreVoiture.anneeDeSortie - this.anneeDeSortie;
    }
    */
}