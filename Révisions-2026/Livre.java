/**
 * Exercice 3 - la valeur devient un objet : code, titre et auteur regroupes.
 */
public class Livre {

    private final String code;
    private final String titre;
    private final String auteur;

    public Livre(String code, String titre, String auteur) {
        this.code   = code;
        this.titre  = titre;
        this.auteur = auteur;
    }

    public String getCode()   { return code; }
    public String getTitre()  { return titre; }
    public String getAuteur() { return auteur; }

    @Override
    public String toString() {
        return code + " - " + titre + " (" + auteur + ")";
    }
}
