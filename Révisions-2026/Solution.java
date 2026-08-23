import java.util.*;
import java.util.stream.*;

/**
 * Exercices de revision Java - ISPM L2 Informatique.
 * Programme unique et autonome : s'execute sans compilation prealable
 *
 *     java Solution.java
 *
 * Il rejoue, section par section, toutes les sorties reproduites dans le corrige.
 */
public class Solution {

    // ==================================================================
    //  Classes utilisees par les exercices 2, 3 et 4
    // ==================================================================

    static class Smartphone implements Comparable<Smartphone> {
        private final String marque;
        private final int    capaciteBatterie;
        private final double tailleEcran;
        private final double prix;
        private final int    anneeSortie;

        Smartphone(String marque, int capaciteBatterie, double tailleEcran,
                   double prix, int anneeSortie) {
            this.marque           = marque;
            this.capaciteBatterie = capaciteBatterie;
            this.tailleEcran      = tailleEcran;
            this.prix             = prix;
            this.anneeSortie      = anneeSortie;
        }

        String getMarque()   { return marque; }
        int    getBatterie() { return capaciteBatterie; }
        double getEcran()    { return tailleEcran; }
        double getPrix()     { return prix; }
        int    getAnnee()    { return anneeSortie; }

        int    age(int anneeCourante) { return anneeCourante - anneeSortie; }
        double densiteBatterie()      { return capaciteBatterie / tailleEcran; }

        @Override public String toString() {
            return String.format(Locale.US, "%s (%d) - %d mAh, %.1f\", %.2f EUR",
                                 marque, anneeSortie, capaciteBatterie, tailleEcran, prix);
        }

        // ordre naturel : priorite au plus recent
        @Override public int compareTo(Smartphone autre) {
            return Integer.compare(autre.anneeSortie, this.anneeSortie);
        }
    }

    static class Livre {
        private final String code, titre, auteur;
        Livre(String code, String titre, String auteur) {
            this.code = code; this.titre = titre; this.auteur = auteur;
        }
        String getCode()   { return code; }
        String getTitre()  { return titre; }
        String getAuteur() { return auteur; }
    }

    static class Bibliotheque {
        private final Map<String, Livre>        livresParCode  = new HashMap<>();
        private final Map<String, List<String>> codesParAuteur = new HashMap<>();

        void ajouter(Livre livre) {
            livresParCode.put(livre.getCode(), livre);
            codesParAuteur.computeIfAbsent(livre.getAuteur(), a -> new ArrayList<>())
                          .add(livre.getCode());
        }
        String titreDe(String code) {
            Livre l = livresParCode.get(code);
            return (l == null) ? null : l.getTitre();
        }
        List<String> titresDe(String auteur) {
            List<String> codes  = codesParAuteur.getOrDefault(auteur, List.of());
            List<String> titres = new ArrayList<>();
            for (String c : codes) titres.add(livresParCode.get(c).getTitre());
            return titres;
        }
        boolean supprimer(String code) {
            Livre l = livresParCode.remove(code);
            if (l == null) return false;
            List<String> codes = codesParAuteur.get(l.getAuteur());
            codes.remove(code);
            if (codes.isEmpty()) codesParAuteur.remove(l.getAuteur());
            return true;
        }
        List<Livre> tousLesLivres() { return new ArrayList<>(livresParCode.values()); }
    }

    // --- catalogue commun aux exercices 2 et 4 ---
    static List<Smartphone> catalogue() {
        return List.of(
            new Smartphone("Nokia",   5000, 6.5,  249, 2023),
            new Smartphone("Xiaomi",  5000, 6.7,  399, 2024),
            new Smartphone("Samsung", 4500, 6.1,  899, 2025),
            new Smartphone("Nokia",   4000, 6.5,  179, 2022),
            new Smartphone("Apple",   3300, 6.1, 1099, 2025));
    }

    static void titre(String t) {
        System.out.println();
        System.out.println("=== " + t + " ===");
    }

    // ==================================================================
    //  Exercice 1 - comprehension
    // ==================================================================

    interface Compteur { int suivant(); }

    static class Boite      { private Object c; void ranger(Object o) { c = o; } Object sortir() { return c; } }
    static class BoiteT<T>  { private T c;      void ranger(T o)      { c = o; } T      sortir() { return c; } }

    static void exercice1() {
        titre("Exercice 1.2.a - genericite : quand l'erreur apparait");
        Boite boite = new Boite();
        boite.ranger("bonjour");
        try {
            Integer n = (Integer) boite.sortir();   // compile, echoue a l'execution
            System.out.println(n);
        } catch (ClassCastException e) {
            System.out.println("version A (sans generique) -> " + e.getClass().getName());
            System.out.println("  " + e.getMessage());
        }
        BoiteT<String> bt = new BoiteT<>();
        bt.ranger("bonjour");
        String s = bt.sortir();                    // Integer n = bt.sortir(); ne compilerait pas
        System.out.println("version B (generique) -> l'erreur equivalente est refusee a la compilation, lu : " + s);

        titre("Exercice 1.2.b - classe anonyme et lambda");
        Comparator<String> anonyme = new Comparator<String>() {
            @Override public int compare(String a, String b) { return Integer.compare(a.length(), b.length()); }
        };
        Comparator<String> lambda = (a, b) -> Integer.compare(a.length(), b.length());
        List<String> mots = new ArrayList<>(List.of("banane", "kiwi", "pomme", "fraise"));
        mots.sort(anonyme); System.out.println("classe anonyme : " + mots);
        mots.sort(lambda);  System.out.println("lambda         : " + mots);

        Compteur c = new Compteur() {
            private int n = 0;                     // un etat : impossible dans une lambda
            @Override public int suivant() { return ++n; }
        };
        System.out.println("compteur anonyme : " + c.suivant() + ", " + c.suivant() + ", " + c.suivant());

        titre("Exercice 1.2.c - Comparable et Comparator");
        List<String> autres = new ArrayList<>(List.of("banane", "kiwi", "pomme", "fraise"));
        Collections.sort(autres);
        System.out.println("ordre naturel : " + autres);
        autres.sort(Comparator.comparingInt(String::length));
        System.out.println("par longueur  : " + autres);

        titre("Exercice 1.2.d - boucle et pipeline");
        List<Smartphone> cat = catalogue();
        Map<String, List<Smartphone>> parMarque = new HashMap<>();
        for (Smartphone p : cat) {
            if (p.getPrix() < 600) parMarque.computeIfAbsent(p.getMarque(), m -> new ArrayList<>()).add(p);
        }
        Map<String, List<Smartphone>> parMarqueStream = cat.stream()
                .filter(p -> p.getPrix() < 600)
                .collect(Collectors.groupingBy(Smartphone::getMarque));
        System.out.println("cles = " + parMarque.keySet()
                         + " tailles des groupes = " + parMarque.values().stream().map(List::size).toList());
        System.out.println("les deux versions sont identiques : " + parMarque.equals(parMarqueStream));
    }

    // ==================================================================
    //  Exercice 2 - file de priorite
    // ==================================================================

    static void exercice2() {
        titre("Exercice 2.1 - ordre naturel : le plus recent d'abord");
        PriorityQueue<Smartphone> file = new PriorityQueue<>(catalogue());
        while (!file.isEmpty()) System.out.println(file.poll());

        titre("Exercice 2.1 - le piege du parcours for-each");
        PriorityQueue<Smartphone> f2 = new PriorityQueue<>(catalogue());
        for (Smartphone p : f2) System.out.println(p.getMarque() + " " + p.getAnnee());
        System.out.println("(l'ordre interne du tas n'est pas l'ordre de priorite)");

        titre("Exercice 2.2.a - ordre alphabetique des marques");
        PriorityQueue<Smartphone> fa =
            new PriorityQueue<>(Comparator.comparing(Smartphone::getMarque));
        fa.addAll(catalogue());
        while (!fa.isEmpty()) System.out.println(fa.poll());

        titre("Exercice 2.2.b - autonomie, puis ecran, puis prix");
        Comparator<Smartphone> parAutonomie =
            Comparator.comparingInt(Smartphone::getBatterie).reversed()
                      .thenComparing(Comparator.comparingDouble(Smartphone::getEcran).reversed())
                      .thenComparingDouble(Smartphone::getPrix);
        PriorityQueue<Smartphone> fb = new PriorityQueue<>(parAutonomie);
        fb.addAll(catalogue());
        while (!fb.isEmpty()) System.out.println(fb.poll());
    }

    // ==================================================================
    //  Exercice 3 - indexation par une chaine
    // ==================================================================

    static void exercice3() {
        titre("Exercice 3, partie A - une Map code -> titre");
        Map<String, String> titresParCode = new HashMap<>();
        titresParCode.put("INF-101", "Programmation Java");
        titresParCode.put("MAT-204", "Analyse numerique");
        titresParCode.put("INF-330", "Algorithmique avancee");
        System.out.println("taille = " + titresParCode.size());
        System.out.println("MAT-204 = " + titresParCode.getOrDefault("MAT-204", "code inconnu"));
        System.out.println("ZZZ-999 = " + titresParCode.getOrDefault("ZZZ-999", "code inconnu"));

        titre("Exercice 3, partie A - HashMap et TreeMap");
        Map<String, String> hm = new HashMap<>();
        hm.put(null, "valeur pour cle null"); hm.put("a", "A"); hm.put("b", "B"); hm.put("c", "C");
        System.out.println("HashMap avec cle null : " + hm);
        TreeMap<String, String> tm = new TreeMap<>(Map.of("b", "B", "a", "A", "c", "C"));
        System.out.println("TreeMap ordre : " + tm.keySet());
        try { tm.put(null, "x"); } catch (NullPointerException e) {
            System.out.println("TreeMap + cle null -> NullPointerException");
        }
        System.out.println("firstKey=" + tm.firstKey()
                         + " ceilingKey(\"ab\")=" + tm.ceilingKey("ab")
                         + " headMap(\"c\")=" + tm.headMap("c"));

        titre("Exercice 3, partie B - double indexation");
        Bibliotheque bib = new Bibliotheque();
        bib.ajouter(new Livre("INF-101", "Programmation Java",    "RAKOTO"));
        bib.ajouter(new Livre("MAT-204", "Analyse numerique",     "RASOA"));
        bib.ajouter(new Livre("INF-330", "Algorithmique avancee", "RAKOTO"));
        bib.ajouter(new Livre("INF-410", "Bases de donnees",      "RAKOTO"));
        System.out.println("titre de INF-330 = " + bib.titreDe("INF-330"));
        System.out.println("livres de RAKOTO = "  + bib.titresDe("RAKOTO"));
        System.out.println("livres de RASOA = "   + bib.titresDe("RASOA"));
        System.out.println("livres de INCONNU = " + bib.titresDe("INCONNU"));
        bib.supprimer("INF-330");
        System.out.println("apres suppression = " + bib.titresDe("RAKOTO"));
    }

    // ==================================================================
    //  Exercice 4 - API Stream
    // ==================================================================

    static void exercice4() {
        List<Smartphone> catalogue = catalogue();

        titre("Exercice 4.2 - evaluation paresseuse");
        Stream<String> s = Stream.of("Alpha", "Beta", "Gamma")
                .filter(x -> { System.out.println("test " + x); return x.length() > 4; });
        System.out.println("avant collect");
        System.out.println(s.collect(Collectors.toList()));

        titre("Exercice 4.3 - un flux ne se parcourt qu'une fois");
        Stream<String> s2 = Stream.of("a", "b");
        s2.count();
        try { s2.count(); } catch (IllegalStateException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        List<Smartphone> abordables = catalogue.stream()
                .filter(p -> p.getPrix() < 500)
                .toList();
        System.out.println("count = " + abordables.size() + ", premier = " + abordables.get(0));

        titre("Exercice 4.4 - Optional");
        Smartphone p = catalogue.stream().filter(x -> x.getPrix() > 2000).findFirst().orElse(null);
        System.out.println("plus de 2000 EUR : " + p);
        catalogue.stream().findFirst()
                 .ifPresentOrElse(x -> System.out.println("premier : " + x),
                                  () -> System.out.println("catalogue vide"));

        titre("Exercice 4.6 - moins de 600 EUR, du plus recent au plus ancien");
        System.out.println(catalogue.stream()
                .filter(x -> x.getPrix() < 600)
                .sorted(Comparator.comparingInt(Smartphone::getAnnee).reversed())
                .toList());

        titre("Exercice 4.7 a 4.12");
        System.out.println("4.7  marques distinctes : "
            + catalogue.stream().map(Smartphone::getMarque).distinct().sorted().toList());
        System.out.println("4.8  prix moyen : "
            + catalogue.stream().mapToDouble(Smartphone::getPrix).average());
        System.out.println("4.8  le plus cher : "
            + catalogue.stream().max(Comparator.comparingDouble(Smartphone::getPrix)));
        System.out.println("4.9  modeles de 2025 ou apres : "
            + catalogue.stream().filter(x -> x.getAnnee() >= 2025).count());
        System.out.println("4.10 marques en une chaine : "
            + catalogue.stream().map(Smartphone::getMarque).distinct().sorted()
                       .collect(Collectors.joining(", ")));
        System.out.println("4.11 batterie cumulee (reduce)   : "
            + catalogue.stream().map(Smartphone::getBatterie).reduce(0, Integer::sum));
        System.out.println("4.11 batterie cumulee (mapToInt) : "
            + catalogue.stream().mapToInt(Smartphone::getBatterie).sum());
        System.out.println("4.12 anyMatch prix > 1000    : "
            + catalogue.stream().anyMatch(x -> x.getPrix() > 1000));
        System.out.println("4.12 allMatch batterie >= 3000 : "
            + catalogue.stream().allMatch(x -> x.getBatterie() >= 3000));
        System.out.println("4.12 noneMatch annee < 2020    : "
            + catalogue.stream().noneMatch(x -> x.getAnnee() < 2020));

        titre("Exercice 4.13 - les trois regroupements");
        Map<String, Long> b = catalogue.stream()
            .collect(Collectors.groupingBy(Smartphone::getMarque, Collectors.counting()));
        Map<String, Double> c = catalogue.stream()
            .collect(Collectors.groupingBy(Smartphone::getMarque,
                                           Collectors.averagingDouble(Smartphone::getPrix)));
        System.out.println("b : " + b);
        System.out.println("c : " + c);
        System.out.println("c trie (TreeMap) : " + catalogue.stream()
            .collect(Collectors.groupingBy(Smartphone::getMarque, TreeMap::new,
                                           Collectors.averagingDouble(Smartphone::getPrix))));

        titre("Exercice 4.14 - de la boucle au pipeline");
        List<String> resultatBoucle = new ArrayList<>();
        for (Smartphone x : catalogue) {
            if (x.getAnnee() >= 2024) resultatBoucle.add(x.getMarque().toUpperCase());
        }
        Collections.sort(resultatBoucle);
        List<String> resultatStream = catalogue.stream()
                .filter(x -> x.getAnnee() >= 2024)
                .map(x -> x.getMarque().toUpperCase())
                .sorted()
                .toList();
        System.out.println("boucle = " + resultatBoucle + " | stream = " + resultatStream
                         + " | identiques = " + resultatBoucle.equals(resultatStream));
        try { resultatStream.add("NOUVEAU"); } catch (UnsupportedOperationException e) {
            System.out.println("toList() rend une liste non modifiable -> UnsupportedOperationException");
        }

        titre("Exercice 4.15 - auteur -> titres, en une instruction");
        List<Livre> livres = List.of(
            new Livre("INF-101", "Programmation Java",    "RAKOTO"),
            new Livre("MAT-204", "Analyse numerique",     "RASOA"),
            new Livre("INF-330", "Algorithmique avancee", "RAKOTO"),
            new Livre("INF-410", "Bases de donnees",      "RAKOTO"));
        Map<String, List<String>> parAuteur = livres.stream()
            .collect(Collectors.groupingBy(Livre::getAuteur,
                     Collectors.mapping(Livre::getTitre, Collectors.toList())));
        System.out.println(parAuteur);
    }

    public static void main(String[] args) {
        exercice1();
        exercice2();
        exercice3();
        exercice4();
    }
}
