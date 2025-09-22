package infographie.data;

import java.awt.Color;
import java.awt.Graphics;

public class EqCart {
    private float x, y;

    public EqCart(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float v) {
        x = v;
    }

    public float getY() {
        return y;
    }

    public int pX(int ox, int echx) {
        return Math.round(ox + (echx * x));
    }

    public int pY(int oy, int echy) {
        return Math.round(oy + (echy * y));
    }

    public void draw(Graphics g, int ox, int oy, int echx, int echy) {
        int truex = pX(ox, echx);
        int truey = pY(oy, echy);

        g.setColor(Color.BLACK);
        g.fillOval(truex, truey, 12, 12);
        // g.drawLine(truex - 3, truey - 3, truex + 3, truey + 3);
        // g.drawLine(truex + 3, truey - 3, truex - 3, truey + 3);

        g.drawString("x: " + String.format("%.2f", x) + "  y: " + String.format("%.2f", y), truex, truey - 3);
    }
}
