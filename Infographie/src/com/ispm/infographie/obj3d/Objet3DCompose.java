package infographie.obj3d;

import java.awt.Color;
import java.awt.Graphics;
import infographie.CoordsRepere;
import infographie.Point;
import infographie.Repere;

public class Objet3DCompose extends RotatingElement3D {

    private Element3D[] objets;

    //TODO : Modifier la classe  Objet3DCompose pour qu'elle combine plusieurs objets 3D qui seront spécifiés dans le constructeur (Parallélogramme3D et Pyramide3D).
    // L'objet composé doit gérer les transformations (rotation, translation) de manière cohérente en calculant un barycentre commun.

    public Objet3DCompose(float x, float y, float z) {
        super(x, y, z, Color.white);

        Parallelogramme3D p3d1 = new Parallelogramme3D(4, 2, 2, Color.blue);
        p3d1.addTranslation(x, y, z);

        Pyramide3D p3d2 = new Pyramide3D(2, 2, Color.blue);
        p3d2.addTranslation(x, y + 2, z);

        objets = new Element3D[] { p3d1, p3d2 };
    }

    @Override
    public void dessiner(Graphics g, Repere repere) {

        for (var obj : objets) {
            obj.dessiner(g, repere);
        }

        CoordsRepere coord = getTranslation().projection2D();
        Point baryPoint = new Point(coord.getxR(), coord.getyR(), 'o', Color.green);
        baryPoint.dessiner(g, repere);
    }

    @Override
    public void update(double deltaTime) {
        for (var obj : objets) {
            for (int i = 0; i < obj.points.length; i++) {
                // Decalage du point
                Point3D c = Point3D.sub(obj.getTranslation(), getTranslation());
                Point3D p = obj.points[i].translate(c);

                p = p.rotateX(deltaTime * getSpeedX());
                p = p.rotateY(deltaTime * getSpeedY());
                p = p.rotateZ(deltaTime * getSpeedZ());

                // Remet le point en position apres decalage
                obj.points[i] = p
                        .translate(Point3D.produitScalair(c, -1f));
            }
        }
    }

}
