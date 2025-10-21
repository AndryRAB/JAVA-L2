package infographie;

import java.awt.Color;

import javax.swing.JFrame;

import infographie.obj3d.Carrer3D;

public class Main {
    public static void main(String[] args) {
        Repere repere = new Repere(512, 600, 40, 40, 1024, 768);
        JFrame frame = new JFrame();

        Carrer3D c3d1 = new Carrer3D(8, 4, 1, 2, Color.red);
        Carrer3D c3d2 = new Carrer3D(4, 4, 1, 2, Color.blue);
        Carrer3D c3d3 = new Carrer3D(0, 4, 1, 2, Color.green);

        repere.onPaint = (i) -> {
            c3d1.selfRotateX(i);
            c3d1.selfRotateY(i);

            c3d2.selfRotateX(-i / 2);
            c3d2.selfRotateZ(i);

            c3d3.selfRotateY(i);
            c3d3.selfRotateZ(i);
        };

        repere.addElement(c3d1);
        repere.addElement(c3d2);
        repere.addElement(c3d3);

        // Placer le repère dans une fenêtre
        frame.setTitle("Infographie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(repere);
        frame.pack();
        frame.setVisible(true);

    }

}