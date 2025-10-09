package infographie;

import javax.swing.JFrame;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Repere repere = new Repere();
        JFrame frame = new JFrame();
        // Quelques points
        repere.addElement(new Point(2, 2.5f));
        repere.addElement(new Point(-3, -1, 'o', Color.RED));
        repere.addElement(new Point(3.5f, 1.5f, 'x', Color.BLUE));
        // Quelques segments 
        repere.addElement(new Segment(new Point(1, 1), new Point(7, 7), Color.BLUE));
        // Quelques courbes - Essayer de faire varier les paramètres
        repere.addElement(new Courbe(x -> x * x, -20.0, 20.0, 100, Color.MAGENTA)); // y = x^2
        repere.addElement(new Courbe(x -> Math.cos(x), -20.0, 20.0, 100, Color.BLUE));  // y = cos(x)
        // Placer le repère dans une fenêtre
        frame.setTitle("Infographie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(repere);
        frame.pack();
        frame.setVisible(true);

        //TODO : Essayer d'ajouter d'autres éléments graphiques
    }

}