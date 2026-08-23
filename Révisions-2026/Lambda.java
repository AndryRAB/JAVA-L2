import java.util.*;

/**
 * Exercice 1, question 2.b et 2.c - classe anonyme, lambda, Comparator.
 */
public class Lambda {

    interface Compteur {
        int suivant();
    }

    interface Deplacable {          // deux methodes abstraites : pas fonctionnelle
        void avancer(int pas);
        void reculer(int pas);
    }

    public static void main(String[] args) {

        // --- classe anonyme vs lambda : meme resultat ---
        Comparator<String> parLongueurAnonyme = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(a.length(), b.length());
            }
        };
        Comparator<String> parLongueurLambda = (a, b) -> Integer.compare(a.length(), b.length());

        List<String> mots = new ArrayList<>(List.of("banane", "kiwi", "pomme", "fraise"));
        mots.sort(parLongueurAnonyme);
        System.out.println("classe anonyme : " + mots);
        mots.sort(parLongueurLambda);
        System.out.println("lambda         : " + mots);

        // --- la classe anonyme peut porter un etat, la lambda non ---
        Compteur c = new Compteur() {
            private int n = 0;                              // impossible dans une lambda
            @Override public int suivant() { return ++n; }
        };
        System.out.println("compteur anonyme : " + c.suivant() + ", " + c.suivant() + ", " + c.suivant());

        // --- interface non fonctionnelle : seule la classe anonyme convient ---
        Deplacable d = new Deplacable() {
            @Override public void avancer(int pas) { System.out.println("avance de " + pas); }
            @Override public void reculer(int pas) { System.out.println("recule de " + pas); }
        };
        d.avancer(3);
        // Deplacable impossible = pas -> System.out.println(pas);  // erreur de compilation

        // --- Comparator vs Comparable sur une classe qu'on ne peut pas modifier ---
        List<String> autres = new ArrayList<>(List.of("banane", "kiwi", "pomme", "fraise"));
        Collections.sort(autres);                                     // ordre naturel de String
        System.out.println("ordre naturel : " + autres);
        autres.sort(Comparator.comparingInt(String::length));         // ordre externe
        System.out.println("par longueur  : " + autres);
    }
}
