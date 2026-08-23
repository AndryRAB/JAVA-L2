import java.util.List;
import java.util.stream.Collectors;

public class Exercice3 {
    public static void main(String[] args) {
        List<Double> notes = List.of(12.5, 8.0, 15.0, 9.5, 17.0, 6.5, 11.0, 19.5);

        System.out.println("# 1) notes >= 10");
        notes.stream()
            .filter(note -> note >= 10.0)
            .forEach(note -> System.out.println(note));

        System.out.println("# 2) nombre d'admis");
        long nbAdmis = notes.stream()
            .filter(note -> note >= 10.0)
            .count();
        System.out.println("Nombre d'admis : " + nbAdmis);

        System.out.println("# 3) moyenne");
        double moyenne = notes.stream()
            .mapToDouble(note -> note)
            .average()
            .orElse(0.0);
        System.out.printf("Moyenne : %.2f%n", moyenne);

        System.out.println("# 4) meilleure note");
        notes.stream()
            .mapToDouble(note -> note)
            .max()
            .ifPresent(meilleure -> System.out.println("Meilleure note : " + meilleure));

        System.out.println("# 5) notes triées par ordre décroissant");
        notes.stream()
            .sorted((n1, n2) -> Double.compare(n2, n1))
            .forEach(note -> System.out.println(note));
    }
}
