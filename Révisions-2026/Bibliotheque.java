import java.util.*;

/**
 * Exercice 3 - double indexation.
 * livresParCode  : index principal   code   -> Livre
 * codesParAuteur : index inverse     auteur -> liste des codes
 * Invariant : les deux Map sont modifiees ensemble, jamais separement.
 */
public class Bibliotheque {

    private final Map<String, Livre>        livresParCode  = new HashMap<>();
    private final Map<String, List<String>> codesParAuteur = new HashMap<>();

    public void ajouter(Livre livre) {
        livresParCode.put(livre.getCode(), livre);
        codesParAuteur.computeIfAbsent(livre.getAuteur(), a -> new ArrayList<>())
                      .add(livre.getCode());
    }

    public String titreDe(String code) {
        Livre l = livresParCode.get(code);
        return (l == null) ? null : l.getTitre();
    }

    public List<String> titresDe(String auteur) {
        List<String> codes  = codesParAuteur.getOrDefault(auteur, List.of());
        List<String> titres = new ArrayList<>();
        for (String c : codes) titres.add(livresParCode.get(c).getTitre());
        return titres;
    }

    public boolean supprimer(String code) {
        Livre l = livresParCode.remove(code);
        if (l == null) return false;
        List<String> codes = codesParAuteur.get(l.getAuteur());
        codes.remove(code);
        if (codes.isEmpty()) codesParAuteur.remove(l.getAuteur());
        return true;
    }

    public int taille() { return livresParCode.size(); }

    public List<Livre> tousLesLivres() { return new ArrayList<>(livresParCode.values()); }
}
