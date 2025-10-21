package infographie;

import java.awt.Color;

import javax.swing.JFrame;

import infographie.obj3d.Parallelogramme3D;

public class Main {
    public static void main(String[] args) {
        Repere repere = new Repere(512, 600, 40, 40, 1024, 768);
        JFrame frame = new JFrame();

        Parallelogramme3D c3d1 = new Parallelogramme3D(8, 4, 1, 2, Color.red);
        Parallelogramme3D c3d2 = new Parallelogramme3D(4, 4, 1, 2, Color.blue);
        Parallelogramme3D c3d3 = new Parallelogramme3D(0, 4, 1, 2, Color.green);

        CarreAnimSimple c2d1 = new CarreAnimSimple(0, 0, 2, Color.yellow);
        repere.addElement(c2d1);

        repere.onPaint = (i) -> {
            c3d1.selfRotateX(i);
            c3d1.selfRotateY(i);

            c3d2.selfRotateX(-i / 2);
            c3d2.selfRotateZ(i);

            c3d3.selfRotateY(i);
            c3d3.selfRotateZ(i);
        };

        // TODO : Modifier le code de Parallelogramme3D pour y inclure les animations (implémenter Animable)
        // et enlever onPaint de Repere. Inspirez-vous de CarreAnimSimple.

        repere.addElement(c3d1);
        repere.addElement(c3d2);
        repere.addElement(c3d3);
        repere.startAnimation();

        // Placer le repère dans une fenêtre
        frame.setTitle("Infographie 3D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(repere);
        frame.pack();
        frame.setVisible(true);
        

    }

}