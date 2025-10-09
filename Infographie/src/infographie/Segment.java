package infographie;

import java.awt.Color;
import java.awt.Graphics;

public class Segment implements Dessinable {
    private Point p1;
    private Point p2;
    private Color color;

    public Segment(Point p1, Point p2, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
    @Override
    public void dessiner(Graphics g, Repere repere) {
        Color oldColor = g.getColor();
        g.setColor(color);
        p1.dessiner(g, repere);
        p2.dessiner(g, repere);
        CoordsEcr ce1 = repere.toEcran(p1);
        CoordsEcr ce2 = repere.toEcran(p2);
        g.drawLine(ce1.getxE(), ce1.getyE(), ce2.getxE(), ce2.getyE());
        g.setColor(oldColor);        
    }
}