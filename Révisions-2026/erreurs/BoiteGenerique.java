/**
 * Exercice 1, question 2.a - version B : avec genericite.
 * CE FICHIER NE COMPILE PAS, ET C'EST LE RESULTAT ATTENDU.
 * Il est isole dans le dossier erreurs/ pour ne pas casser la compilation du reste.
 */
public class BoiteGenerique {

    static class Boite<T> {
        private T contenu;
        public void ranger(T o) { contenu = o; }
        public T sortir()       { return contenu; }
    }

    public static void main(String[] args) {
        Boite<String> b = new Boite<>();
        b.ranger("bonjour");
        Integer n = b.sortir();   // refuse par le compilateur
        System.out.println(n);
    }
}
