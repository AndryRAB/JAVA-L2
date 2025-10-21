package infographie;

import java.awt.Color;
import java.awt.Graphics;

public class Carrer2D implements Dessinable {

    private Point[] points;
    private Color color;

    public Carrer2D(int x, int y, int arret, Color color) {
        points = new Point[4];
        int d = arret / 2;
        points[0] = new Point(x - d, y - d, 'o', Color.GREEN);
        points[1] = new Point(x + d, y - d, 'o', Color.GREEN);
        points[2] = new Point(x + d, y + d, 'o', Color.GREEN);
        points[3] = new Point(x - d, y + d, 'o', Color.GREEN);
        this.color = color;
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
