package infographie;

import java.awt.Color;
import java.awt.Graphics;
public class Point extends CoordsRepere implements Dessinable {
    private char type; 
    private Color color;
    private static final int TAILLE = 4;
    public Point(float xR, float yR, char type, Color c) {
        super(xR, yR);
        this.type = type;
        this.color = c;
    }
    public Point(float xR, float yR) {
        this(xR, yR, 'x', Color.BLACK);
    }
    public Point(float xR, float yR, char type) {
        this(xR, yR, type, Color.BLACK);
    }
    
    @Override
    public void dessiner(Graphics g, Repere repere){
        CoordsEcr ce = repere.toEcran(this);
        Color oldColor = g.getColor(); 
        g.setColor(color);
        switch (type) {
            case 'x': // croix
                g.drawLine(ce.getxE()-TAILLE, ce.getyE()-TAILLE, ce.getxE()+TAILLE, ce.getyE()+TAILLE);
                g.drawLine(ce.getxE()-TAILLE, ce.getyE()+TAILLE, ce.getxE()+TAILLE, ce.getyE()-TAILLE);
                break;
            case 'o': // cercle
                g.fillOval(ce.getxE()-TAILLE, ce.getyE()-TAILLE, TAILLE*2, TAILLE*2); 
                break;
            case '+': // plus
                g.drawLine(ce.getxE()-TAILLE, ce.getyE(), ce.getxE()+TAILLE, ce.getyE());
                g.drawLine(ce.getxE(), ce.getyE()-TAILLE, ce.getxE(), ce.getyE()+TAILLE);
                break;     
            default: // cercle creux, par défaut
                g.drawOval(ce.getxE()-TAILLE, ce.getyE()-TAILLE, TAILLE*2, TAILLE*2);
                break;
        }
        g.setColor(oldColor); // pour ne pas perturber la couleur des autres dessins
    }
}