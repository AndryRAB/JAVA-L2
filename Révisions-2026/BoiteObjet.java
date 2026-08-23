/**
 * Exercice 1, question 2.a - version A : sans genericite.
 * Compile sans avertissement, echoue a l'execution.
 */
public class BoiteObjet {

    static class Boite {
        private Object contenu;
        public void ranger(Object o) { contenu = o; }
        public Object sortir()       { return contenu; }
    }

    public static void main(String[] args) {
        Boite b = new Boite();
        b.ranger("bonjour");
        Integer n = (Integer) b.sortir();   // transtypage accepte a la compilation
        System.out.println(n);
    }
}
