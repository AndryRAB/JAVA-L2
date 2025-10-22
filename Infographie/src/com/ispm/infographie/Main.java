package infographie;

import java.awt.Color;

import javax.swing.JFrame;

import infographie.obj3d.Parallelogramme3D;
import infographie.obj3d.Pyramide3D;

public class Main {
    public static void main(String[] args) {
        Repere repere = new Repere(512, 600, 40, 40, 1024, 768);
        JFrame frame = new JFrame();

        // CarreAnimSimple c2d1 = new CarreAnimSimple(0, 0, 2, Color.yellow);
        // repere.addElement(c2d1);

        Parallelogramme3D p3d1 = new Parallelogramme3D(5, 2, 2, Color.blue);
        p3d1.addTranslation(6, 2, 2);

        Pyramide3D p3d2 = new Pyramide3D(2, 2, Color.blue);
        p3d2.addTranslation(6, 4.5f, 2);

        p3d1.addRotationSpeed(0, 0.5, 0);
        p3d2.addRotationSpeed(0, 0.5, 0);


        Parallelogramme3D p3d3 = new Parallelogramme3D(5, 2, 2, Color.green);
        p3d3.addTranslation(0, 2, 2);


        Pyramide3D p3d4 = new Pyramide3D(2, 2, Color.green);
        p3d4.addTranslation(0, 4.5f, 2);

        p3d3.addRotationSpeed(1, 1.0, 0);  // les problèmes apparaissent ici car les centres sont différents par rapport à l"axe X
        p3d4.addRotationSpeed(1, 1.0, 0);


        Parallelogramme3D p3d5 = new Parallelogramme3D(5, 2, 2, Color.red);
        p3d5.addTranslation(-6, 2, 2);

        Pyramide3D p3d6 = new Pyramide3D(2, 2, Color.red);
        p3d6.addTranslation(-6, 4.5f, 2);
        
        p3d5.addRotationSpeed(0, 1.0, 1); // les problèmes apparaissent ici car les centres sont différents par rapport à l"axe Z
        p3d6.addRotationSpeed(0, 1.0, 1);

        // TODO : Créer une classe Objet3DComposé qui regroupe plusieurs objets un Parallélogramme3D et une Pyramide3D,
        // et qui gère les transformations de manière cohérente. en calculant un barycentre commun.

        repere.addElement(p3d1);
        repere.addElement(p3d2);
        repere.addElement(p3d3);
        repere.addElement(p3d4);
        repere.addElement(p3d5);
        repere.addElement(p3d6);
        repere.startAnimation();

        // Placer le repère dans une fenêtre
        frame.setTitle("Infographie 3D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(repere);
        frame.pack();
        frame.setVisible(true);

    }

}