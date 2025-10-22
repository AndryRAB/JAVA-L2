package infographie.obj3d;

import java.awt.Color;

public class Parallelogramme3D extends RotatingElement3D{

    public Parallelogramme3D(float hauteur, float largeur, float profondeur, Color color) {
        super(0, 0, 0, color);

        this.points = new Point3D[8];

        float d = largeur / 2.f;
        float h = hauteur / 2.f;

        // Avant
        points[0] = new Point3D(-d, -h, 0);
        points[1] = new Point3D(d, -h, 0);
        points[2] = new Point3D(d, h, 0);
        points[3] = new Point3D(-d, h, 0);

        // Ariere
        points[4] = new Point3D(-d, -h, -profondeur);
        points[5] = new Point3D(d, -h, -profondeur);
        points[6] = new Point3D(d, h, -profondeur);
        points[7] = new Point3D(-d, h, -profondeur);

        // Ordre de traçage (par index des points)
        rang = new int[] { 0, 1, 2, 3, 0,
                4, 5, 6, 7, 4,
                7, 3, 2, 6, 7,
                4, 5, 1, 0, 4 };
    }

}
