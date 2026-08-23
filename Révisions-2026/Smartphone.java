import java.util.Locale;

/**
 * Exercice 2 - la classe Smartphone.
 * Ordre naturel retenu : priorite au modele le plus recent.
 */
public class Smartphone implements Comparable<Smartphone> {

    private final String marque;
    private final int    capaciteBatterie;   // en mAh
    private final double tailleEcran;        // en pouces
    private final double prix;               // en euros
    private final int    anneeSortie;

    public Smartphone(String marque, int capaciteBatterie, double tailleEcran,
                      double prix, int anneeSortie) {
        this.marque           = marque;
        this.capaciteBatterie = capaciteBatterie;
        this.tailleEcran      = tailleEcran;
        this.prix             = prix;
        this.anneeSortie      = anneeSortie;
    }

    public String getMarque()   { return marque; }
    public int    getBatterie() { return capaciteBatterie; }
    public double getEcran()    { return tailleEcran; }
    public double getPrix()     { return prix; }
    public int    getAnnee()    { return anneeSortie; }

    // --- (b) deux methodes au choix ---
    public int age(int anneeCourante) {
        return anneeCourante - anneeSortie;
    }

    public double densiteBatterie() {          // mAh par pouce d'ecran
        return capaciteBatterie / tailleEcran;
    }

    // --- (c) representation textuelle ---
    @Override
    public String toString() {
        return String.format(Locale.US, "%s (%d) - %d mAh, %.1f\", %.2f EUR",
                             marque, anneeSortie, capaciteBatterie, tailleEcran, prix);
    }

    // --- (d) ordre naturel : priorite au plus recent ---
    @Override
    public int compareTo(Smartphone autre) {
        return Integer.compare(autre.anneeSortie, this.anneeSortie);
    }
}
