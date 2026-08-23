import java.util.*;
import java.util.stream.*;

/**
 * Exercice 1, question 2.d - la meme Map obtenue par une boucle puis par un pipeline.
 */
public class BoucleEtPipeline {

    public static void main(String[] args) {

        List<Smartphone> catalogue = List.of(
            new Smartphone("Nokia",   5000, 6.5,  249, 2023),
            new Smartphone("Xiaomi",  5000, 6.7,  399, 2024),
            new Smartphone("Samsung", 4500, 6.1,  899, 2025),
            new Smartphone("Nokia",   4000, 6.5,  179, 2022),
            new Smartphone("Apple",   3300, 6.1, 1099, 2025));

        // --- version boucle ---
        Map<String, List<Smartphone>> parMarque = new HashMap<>();
        for (Smartphone p : catalogue) {
            if (p.getPrix() < 600) {
                parMarque.computeIfAbsent(p.getMarque(), m -> new ArrayList<>()).add(p);
            }
        }

        // --- version pipeline ---
        Map<String, List<Smartphone>> parMarqueStream = catalogue.stream()
                .filter(p -> p.getPrix() < 600)
                .collect(Collectors.groupingBy(Smartphone::getMarque));

        System.out.println("cles = " + parMarque.keySet()
                         + " tailles des groupes = "
                         + parMarque.values().stream().map(List::size).toList());
        System.out.println("les deux versions sont identiques : "
                         + parMarque.equals(parMarqueStream));
    }
}
