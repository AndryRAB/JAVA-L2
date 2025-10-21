package infographie.obj3d;

import java.awt.Color;
import java.awt.Graphics;

import infographie.CoordsEcr;
import infographie.Dessinable;
import infographie.Repere;

public class Carrer3D implements Dessinable {

    private Point3D[] points;
    private int[] rang;
    private Color color;
    private int tx, ty, tz;

    public Carrer3D(int x, int y, int z, int arret, Color color) {
        this.points = new Point3D[8];
        this.color = color;
        int d = arret / 2;
        tx = x;
        ty = y;
        tz = z;

        // Avant
        points[0] = new Point3D(-d, -d, 0, 'o', color);
        points[1] = new Point3D(d, -d, 0, 'o', color);
        points[2] = new Point3D(d, d, 0, 'o', color);
        points[3] = new Point3D(-d, d, 0, 'o', color);

        // Ariere
        points[4] = new Point3D(-d, -d, -d, 'o', color);
        points[5] = new Point3D(d, -d, -d, 'o', color);
        points[6] = new Point3D(d, d, -d, 'o', color);
        points[7] = new Point3D(-d, d, -d, 'o', color);

        rang = new int[] { 0, 1, 2, 3, 0,
                4, 5, 6, 7, 4,
                7, 3, 2, 6, 7,
                4, 5, 1, 0, 4 };
    }

    @Override
    public void dessiner(Graphics g, Repere repere) {

        Color oldColor = g.getColor();
        g.setColor(this.color);

        for (int i = 0; i < rang.length - 1; i++) {

            CoordsEcr coord1 = repere.toEcran(points[rang[i]].translate(tx, ty, tz));
            CoordsEcr coord2 = repere.toEcran(points[rang[i + 1]].translate(tx, ty, tz));

            g.drawLine(coord1.getxE(), coord1.getyE(), coord2.getxE(), coord2.getyE());
        }

        g.setColor(oldColor);

    }

    public void selfRotateX(double alpha) {
        for (int i = 0; i < points.length; i++)
            points[i] = points[i].rotateX(alpha);
    }

    public void selfRotateY(double alpha) {
        for (int i = 0; i < points.length; i++)
            points[i] = points[i].rotateY(alpha);
    }

    public void selfRotateZ(double alpha) {
        for (int i = 0; i < points.length; i++)
            points[i] = points[i].rotateZ(alpha);
    }

}
