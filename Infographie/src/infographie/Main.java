package infographie;

import javax.swing.JFrame;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Repere repere = new Repere();
        JFrame frame = new JFrame();
        repere.addElement(new Point(2, 2.5f));
        repere.addElement(new Point(-3, -1, 'o', Color.RED));
        repere.addElement(new Point(3.5f, 1.5f, 'x', Color.BLUE));
        repere.addElement(new Segment(new Point(1, 1), new Point(7, 7), Color.BLUE));
        repere.addElement(new Courbe(x -> x * x, -20.0, 20.0, 100, Color.MAGENTA));
        repere.addElement(new Courbe(x -> Math.cos(x), -20.0, 20.0, 100, Color.BLUE));        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(repere);
        frame.pack();
        frame.setVisible(true);
    }

}