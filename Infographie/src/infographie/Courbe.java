package infographie;

import java.util.function.Function;
import java.awt.Color;
import java.awt.Graphics;

public class Courbe implements Dessinable {
    
    Function<Double, Double> f;
    double xMin, xMax;
    int n; // nombre de segments
    Color color;

    public Courbe(Function<Double, Double> f, double xMin, double xMax, int n, Color color) {
        this.f = f;
        this.xMin = xMin;
        this.xMax = xMax;
        this.n = n;
        this.color = color;
    }

    @Override
    public void dessiner(Graphics g, Repere repere) {
        Color oldColor = g.getColor();
        g.setColor(this.color);
        double step = (xMax - xMin) / n;
        for (int i = 0; i < n; i++) {
            double x1 = xMin + i * step;
            double y1 = f.apply(x1);
            double x2 = xMin + (i + 1) * step;
            double y2 = f.apply(x2);
            CoordsEcr ce1 = repere.toEcran(new CoordsRepere((float)x1, (float)y1));
            CoordsEcr ce2 = repere.toEcran(new CoordsRepere((float)x2, (float)y2));
            g.drawLine(ce1.getxE(), ce1.getyE(), ce2.getxE(), ce2.getyE());
        }
        g.setColor(oldColor);
    }
    
}