package infographie;

public class CoordsEcr { //Coordonnées d'un point à l'écran
    private int xE; 
    private int yE; 

    public CoordsEcr(int xE, int yE) {
        this.xE = xE;
        this.yE = yE;
    }

    public int getxE() {
        return xE;
    }

    public int getyE() {
        return yE;
    }
}