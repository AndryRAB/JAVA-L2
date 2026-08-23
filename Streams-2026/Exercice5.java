import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercice5 {

    record Etudiant(String matricule, String nom, String prenom, int niveau, double moyenne) {}

    public static void main(String[] args) {
        List<Etudiant> etudiants = List.of(
            new Etudiant("2023-001", "Rakoto",         "Andry",     2, 15.5),
            new Etudiant("2023-002", "Rabe",            "Mathias",   3, 12.0),
            new Etudiant("2023-003", "Rajaonarivelo",   "Koloina",   1, 18.0),
            new Etudiant("2023-004", "Rakotomalala",    "Fifaliana", 2, 14.0),
            new Etudiant("2023-005", "Rasoa",           "Antso",     3, 16.5),
            new Etudiant("2023-006", "Rajaonarivelo",   "Miora",     1, 19.0),
            new Etudiant("2023-007", "Randriamampionona", "Bako",    2, 7.0)
        );

        System.out.println("# 1) et 2) admis / non admis, en un seul partitioningBy");
        Map<Boolean, List<Etudiant>> partition = etudiants.stream()
            .collect(Collectors.partitioningBy(etudiant -> etudiant.moyenne() >= 10.0));

        System.out.println("-- Admis --");
        partition.get(true)
            .forEach(etudiant -> System.out.println(etudiant.nom() + " " + etudiant.prenom() + " - Moyenne : " + etudiant.moyenne()));

        System.out.println("-- Non admis --");
        partition.get(false)
            .forEach(etudiant -> System.out.println(etudiant.nom() + " " + etudiant.prenom() + " - Moyenne : " + etudiant.moyenne()));

        System.out.println("# 3) étudiants triés par moyenne décroissante");
        etudiants.stream()
            .sorted((e1, e2) -> Double.compare(e2.moyenne(), e1.moyenne()))
            .forEach(etudiant -> System.out.println(etudiant.nom() + " " + etudiant.prenom() + " - Moyenne : " + etudiant.moyenne()));

        System.out.println("# 4) moyenne générale");
        double moyenneGenerale = etudiants.stream()
            .mapToDouble(Etudiant::moyenne)
            .average()
            .orElse(0.0);
        System.out.printf("Moyenne générale : %.2f%n", moyenneGenerale);

        System.out.println("# 5) étudiants regroupés par niveau");
        Map<Integer, List<Etudiant>> parNiveau = etudiants.stream()
            .collect(Collectors.groupingBy(Etudiant::niveau));
        parNiveau.forEach((niveau, liste) -> {
            System.out.println("Niveau " + niveau + " :");
            liste.forEach(etudiant -> System.out.println("  " + etudiant.nom() + " " + etudiant.prenom() + " - Moyenne : " + etudiant.moyenne()));
        });

        System.out.println("# 6) meilleur étudiant");
        etudiants.stream()
            .max((e1, e2) -> Double.compare(e1.moyenne(), e2.moyenne()))
            .ifPresent(etudiant -> System.out.println("Meilleur étudiant : " + etudiant.nom() + " " + etudiant.prenom() + " - Moyenne : " + etudiant.moyenne()));
    }
}
