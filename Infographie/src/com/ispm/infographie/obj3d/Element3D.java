package infographie.obj3d;

import java.awt.Color;
import java.awt.Graphics;

import infographie.Animable;
import infographie.CoordsEcr;
import infographie.Dessinable;
import infographie.Repere;

// Wow, abstract transfert les methodes de l'interface automatiquement
public abstract class Element3D implements Animable, Dessinable {

    protected Point3D[] points;
    protected int[] rang;
    protected Color color;
    protected Point3D translation;

    protected double speed;

    public Element3D(float x, float y, float z, Color color) {
        this.color = color;
        translation = new Point3D(x, y, z);
        speed = 2f;
    }

    public Element3D(int x, int y, int z) {
        this(x, y, z, Color.WHITE);
    }

    @Override
    public void dessiner(Graphics g, Repere repere) {
        Color oldColor = g.getColor();
        g.setColor(this.color);

        for (int i = 0; i < rang.length - 1; i++) {

            CoordsEcr coord1 = repere.toEcran(points[rang[i]].translate(translation).projection2D());
            CoordsEcr coord2 = repere.toEcran(points[rang[i + 1]].translate(translation).projection2D());

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

    public Point3D getTranslation() {
        return translation;
    }

    public void addTranslation(float x, float y, float z) {
        this.translation = new Point3D(x, y, z);
    }

    public Point3D[] getPoints() {
        return points;
    }

    public void rotateAroundPoint(Point3D center, double angleX, double angleY, double angleZ) {
        // Rotate the element as a whole around a global center.
        // Approach: rotate the element's translation (its world position) around the
        // center,
        // and rotate the local points to change its orientation.

        // 1) Rotate the translation (position) around the center
        Point3D negativeCenter = new Point3D(-center.getxR(), -center.getyR(), -center.getZ());
        Point3D transRel = this.translation.translate(negativeCenter);

        if (angleX != 0)
            transRel = transRel.rotateX(angleX);
        if (angleY != 0)
            transRel = transRel.rotateY(angleY);
        if (angleZ != 0)
            transRel = transRel.rotateZ(angleZ);

        this.translation = transRel.translate(center);

        // 2) Rotate the local geometry (orientation)
        if (angleX != 0)
            selfRotateX(angleX);
        if (angleY != 0)
            selfRotateY(angleY);
        if (angleZ != 0)
            selfRotateZ(angleZ);
    }

    public Point3D getBarycentre() {

        float sumX = 0, sumY = 0, sumZ = 0;

        for (Point3D p : points) {
            Point3D translated = p.translate(translation);

            sumX += translated.getxR();
            sumY += translated.getyR();
            sumZ += translated.getZ();
        }

        float d = points.length;

        if (d == 0)
            return null;

        return new Point3D(sumX / d, sumY / d, sumZ / d);

    }
}
