package infographie.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import infographie.data.EqCart;
import infographie.data.Transformation;

public class View extends JPanel implements ActionListener {

    private int echx, echy;
    private int ox, oy;

    private EqCart E;

    private Timer timer;

    public View() {
        super();

        echx = 30;
        echy = 30;

        E = new EqCart(-10f, 0f);

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ox = this.getWidth() / 2;
        oy = this.getHeight() / 2;

        g.setColor(Color.gray);

        // Axe x
        g.drawLine(ox, 0, ox, this.getHeight());

        // Axe y
        g.drawLine(0, oy, this.getWidth(), oy);

        drawRepere(g);

        E.draw(g, ox, oy, echx, echy);
    }

    private void drawRepere(Graphics g) {

        // Axe x
        for (int x = ox + echx; x + echx < this.getWidth(); x += echx)
            g.drawLine(x, oy - 3, x, oy + 3);
        for (int x = ox - echx; x - echx > 0; x -= echx)
            g.drawLine(x, oy - 3, x, oy + 3);

        // Axe y
        for (int y = oy + echy; y + echy < this.getHeight(); y += echy)
            g.drawLine(ox - 3, y, ox + 3, y);
        for (int y = oy - echy; y - echy >= 0; y -= echy)
            g.drawLine(ox - 3, y, ox + 3, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        E = Transformation.sinusoidal(E, 0.02f, 2f);
        if (E.pX(ox, echx) > this.getWidth()) {
            E.setX(0);
        }
        repaint();
    }

}
