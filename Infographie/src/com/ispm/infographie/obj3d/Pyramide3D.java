package infographie.obj3d;

import java.awt.Color;

public class Pyramide3D extends RotatingElement3D {

    public Pyramide3D(float taille, float hauteur, Color color) {
        super(0, 0, 0, color);

        points = new Point3D[5];

        float d = taille / 2.0f;

        points[0] = new Point3D(-d, 0, 0); // Devant Gauche
        points[1] = new Point3D(d, 0, 0); // Devant droite
        points[2] = new Point3D(-d, 0, -taille); // Arrier Gauche
        points[3] = new Point3D(d, 0, -taille); // Arrier droite

        points[4] = new Point3D(0, hauteur, -d); // Haut Centrale

        rang = new int[] {
                0, 1, 3, 2, 0,
                4, 2, 3, 4, 1
        };
    }
    
}
