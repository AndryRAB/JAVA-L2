package infographie;

public class CoordsRepere {
    private float xR; // x coordinate in the reference frame
    private float yR; // y coordinate in the reference frame   
    public CoordsRepere(float xR, float yR) {
        this.xR = xR;
        this.yR = yR;
    }   
    public float getxR() {
        return xR;
    }
    public float getyR() {
        return yR;
    }

}