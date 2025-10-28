package infographie;

import javax.swing.JFrame;

import infographie.obj3d.Objet3DCompose;

public class Main {
    public static void main(String[] args) {
        Repere repere = new Repere(512, 600, 40, 40, 1024, 768);
        JFrame frame = new JFrame();

        // TODO : Créer une classe Objet3DComposé qui regroupe plusieurs objets un
        // Parallélogramme3D et une Pyramide3D,
        // et qui gère les transformations de manière cohérente. en calculant un
        // barycentre commun.

        Objet3DCompose obj3D = new Objet3DCompose(2.f, 5.f, 1.f);
        obj3D.addRotationSpeed(0, 1f, 0.5f);

        repere.addElement(obj3D);
        repere.startAnimation();

        // Placer le repère dans une fenêtre
        frame.setTitle("Infographie 3D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(repere);
        frame.pack();
        frame.setVisible(true);

        //TODO : créer une classe Repère3D qui hérite de Repère et qui ajoute des axes X, Y, Z visibles. Et qui contient la projection 3D au lieu de les mettre dans les Objet3D directement.

    }

}