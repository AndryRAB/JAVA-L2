import java.util.List;

public class Exercice2 {
    public static void main(String[] args) {
        List<String> noms = List.of(
            "Andry", "Miora", "Antso", "Fifaliana", "Koloina",
            "Mathias", "Bako", "Ainatiana"
        );

        System.out.println("# 1) tous les noms");
        noms.stream()
            .forEach(nom -> System.out.println(nom));

        System.out.println("# 2) noms commençant par A");
        noms.stream()
            .filter(nom -> nom.startsWith("A"))
            .forEach(nom -> System.out.println(nom));

        System.out.println("# 3) noms en majuscules");
        noms.stream()
            .map(nom -> nom.toUpperCase())
            .forEach(nom -> System.out.println(nom));

        System.out.println("# 4) noms triés par ordre alphabétique");
        noms.stream()
            .sorted()
            .forEach(nom -> System.out.println(nom));

        System.out.println("# 5) nombre de noms de plus de 5 caractères");
        long nbLongs = noms.stream()
            .filter(nom -> nom.length() > 5)
            .count();
        System.out.println("Nombre de noms de plus de 5 caractères : " + nbLongs);
    }
}
