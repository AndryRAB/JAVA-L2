package infographie;

public class CoordsEcr { //screen coordinates of a point    
    private int xE; // x coordinate on screen
    private int yE; // y coordinate on screen

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