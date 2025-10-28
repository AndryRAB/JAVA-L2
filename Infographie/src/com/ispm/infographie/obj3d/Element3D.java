package infographie.obj3d;

import java.awt.Color;
import java.awt.Graphics;

import infographie.Animable;
import infographie.CoordsEcr;
import infographie.CoordsRepere;
import infographie.Dessinable;
import infographie.Point;
import infographie.Repere;

public abstract class Element3D implements Animable, Dessinable {

    protected Point3D[] points;
    protected int[] rang;
    protected Color color;
    protected Point3D translation;

    public Element3D(float x, float y, float z, Color color) {
        this.color = color;
        translation = new Point3D(x, y, z);
    }

    public Element3D(int x, int y, int z) {
        this(x, y, z, Color.WHITE);
    }

    @Override
    public void dessiner(Graphics g, Repere repere) {
        Color oldColor = g.getColor();
        g.setColor(this.color);

        CoordsRepere baryCentre = translation.projection2D();

        Point baryPoint = new Point(baryCentre.getxR(), baryCentre.getyR(), 'x', Color.red);

        for (int i = 0; i < rang.length - 1; i++) {

            CoordsEcr coord1 = repere.toEcran(points[rang[i]].translate(translation).projection2D());
            CoordsEcr coord2 = repere.toEcran(points[rang[i + 1]].translate(translation).projection2D());

            g.drawLine(coord1.getxE(), coord1.getyE(), coord2.getxE(), coord2.getyE());
        }

        baryPoint.dessiner(g, repere);

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

    public Point3D getTranslation() {
        return translation;
    }

    public void addTranslation(float x, float y, float z) {
        this.translation = new Point3D(x, y, z);
    }

    public Point3D[] getPoints() {
        return points;
    }
}
