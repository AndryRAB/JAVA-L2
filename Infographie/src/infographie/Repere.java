package infographie;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Repere extends JPanel {

    private int ox = 400; // Coordonnée x de l'origine
    private int oy = 300; // Coordonnée y de l'origine
    private int echx = 20; // Facteur d'échelle
    private int echy = 20; // Facteur d'échelle

    private LinkedList<Dessinable> elements = new LinkedList<>();
    
    public Repere(int ox, int oy, int echx, int echy) {
        super();
        this.ox = ox;
        this.oy = oy;
        this.echx = echx;
        this.echy = echy;
        elements = new LinkedList<>();
        setPreferredSize(new Dimension(800, 600));
    }

    public Repere() {        
        super();
        elements = new LinkedList<>();
        setPreferredSize(new Dimension(800, 600));
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
        g.drawLine(0, height / 2, width, height / 2); // Axe horizontale
        g.drawLine(width / 2, 0, width / 2, height); // Axe verticale

        // Graduations
        for (int x = ox + echx; x < width; x += echx) {
            g.drawLine(x, oy - 5, x, oy + 5);
        }
        for (int x = ox-echx; x > 0; x -= echx) {
            g.drawLine(x, oy - 5, x, oy + 5);
        }        
        for (int y = oy+echy; y < height; y += echy) {
            g.drawLine(ox - 5, y, ox + 5, y);
        }
        for (int y = oy-echy; y > 0; y -= echy) {
            g.drawLine(ox - 5, y, ox + 5, y);
        }        

         // Dessine tous les éléments

        for (Dessinable element : elements) {
            element.dessiner(g, this);
        }   

    }
}