package infographie;

import java.awt.Color;
import java.awt.Graphics;

public class Carre2D implements Dessinable {

    protected CoordsRepere[] points = new CoordsRepere[4];
    protected CoordsRepere centre;
    protected float arete;
    protected Color color;

    public Carre2D(float x, float y, float arete, Color color) {
        centre = new CoordsRepere(x, y);
        this.arete = arete;
        calculePoints();
        this.color = color;
    }

    public void calculePoints() {
        float d = arete / 2;        
        float x =  centre.getxR();
        float y =  centre.getyR();
        points[0] = new CoordsRepere(x - d, y - d); 
        points[1] = new CoordsRepere(x + d, y - d);
        points[2] = new CoordsRepere(x + d, y + d);
        points[3] = new CoordsRepere(x - d, y + d);
    }

    @Override
    public void dessiner(Graphics g, Repere repere) {
        Color oldColor = g.getColor();
        g.setColor(color);
        for (int i = 0; i < 4; i++) {
            CoordsEcr coord1 = repere.toEcran(points[i]);
            CoordsEcr coord2 = repere.toEcran(points[(i + 1) % 4]);

            g.drawLine(coord1.getxE(), coord1.getyE(), coord2.getxE(), coord2.getyE());
        }
        g.setColor(oldColor);
    }

}
