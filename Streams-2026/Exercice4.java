import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercice4 {

    record Produit(String nom, String categorie, double prix) {}

    public static void main(String[] args) {
        List<Produit> produits = List.of(
            new Produit("Vary gasy",        "Alimentation", 8000),
            new Produit("Ravitoto sy henakisoa", "Alimentation", 15000),
            new Produit("Lamba landy",      "Artisanat",    45000),
            new Produit("Vakoka mihogo",    "Artisanat",    12500),
            new Produit("Kafe gasy",        "Alimentation", 9500),
            new Produit("Sombily",          "Alimentation", 22000),
            new Produit("Sokay",            "Artisanat",    6000)
        );

        System.out.println("# 1) produits de prix > 10000");
        produits.stream()
            .filter(produit -> produit.prix() > 10000)
            .forEach(produit -> System.out.println(produit.nom() + " (" + produit.categorie() + ") - " + produit.prix() + " Ar"));

        System.out.println("# 2) produits triés par prix décroissant");
        produits.stream()
            .sorted((p1, p2) -> Double.compare(p2.prix(), p1.prix()))
            .forEach(produit -> System.out.println(produit.nom() + " - " + produit.prix() + " Ar"));

        System.out.println("# 3) prix moyen");
        double prixMoyen = produits.stream()
            .mapToDouble(Produit::prix)
            .average()
            .orElse(0.0);
        System.out.printf("Prix moyen : %.2f Ar%n", prixMoyen);

        System.out.println("# 4) produits regroupés par catégorie");
        Map<String, List<Produit>> parCategorie = produits.stream()
            .collect(Collectors.groupingBy(Produit::categorie));
        parCategorie.forEach((categorie, liste) -> {
            System.out.println(categorie + " :");
            liste.forEach(produit -> System.out.println("  " + produit.nom()));
        });

        System.out.println("# 5) produit le plus cher");
        produits.stream()
            .max((p1, p2) -> Double.compare(p1.prix(), p2.prix()))
            .ifPresent(produit -> System.out.println("Produit le plus cher : " + produit.nom() + " - " + produit.prix() + " Ar"));
    }
}
