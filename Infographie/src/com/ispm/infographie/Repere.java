package infographie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.Timer;
import java.util.function.Consumer;

import javax.swing.JPanel;

public class Repere extends JPanel implements ActionListener {

    private int ox = 400; // Coordonnée x de l'origine
    private int oy = 300; // Coordonnée y de l'origine
    private int echx = 20; // Facteur d'échelle
    private int echy = 20; // Facteur d'échelle

    public Consumer<Double> onPaint;
    private LinkedList<Dessinable> elements = new LinkedList<>();

    private Timer timer;
    private double alphaTest;

    public Repere(int ox, int oy, int echx, int echy, int width, int height) {
        super();
        this.ox = ox;
        this.oy = oy;
        this.echx = echx;
        this.echy = echy;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.black);
        elements = new LinkedList<>();
        alphaTest = 0;

        timer = new Timer(16, this);
        timer.start();
    }

    public Repere() {
        this(400, 300, 20, 20, 800, 600);
    }

    public Repere(int width, int height, int echx, int echy) {
        this(width / 2, height / 2, echx, echy, width, height);
    }

    public void addElement(Dessinable d) {
        elements.add(d);
    }

    public int getOx() {
        return ox;
    }

    public int getOy() {
        return oy;
    }

    public int getEchx() {
        return echx;
    }

    public int getEchy() {
        return echy;
    }

    public CoordsEcr toEcran(CoordsRepere cr) {
        int xE = ox + Math.round(cr.getxR() * echx);
        int yE = oy - Math.round(cr.getyR() * echy);
        return new CoordsEcr(xE, yE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.darkGray);

        g.drawLine(0, oy, width, oy); // Axe horizontale
        g.drawLine(ox, 0, ox, height); // Axe verticale

        // Graduations
        for (int x = ox + echx; x < width; x += echx) {
            g.drawLine(x, oy - 5, x, oy + 5);
        }
        for (int x = ox - echx; x > 0; x -= echx) {
            g.drawLine(x, oy - 5, x, oy + 5);
        }
        for (int y = oy + echy; y < height; y += echy) {
            g.drawLine(ox - 5, y, ox + 5, y);
        }
        for (int y = oy - echy; y > 0; y -= echy) {
            g.drawLine(ox - 5, y, ox + 5, y);
        }

        // Dessine tous les éléments

        for (Dessinable element : elements) {
            element.dessiner(g, this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (onPaint == null)
            return;

        onPaint.accept(alphaTest);
        alphaTest += 0.0001;
        repaint();
    }
}