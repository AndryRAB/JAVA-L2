
package infographie;

import java.awt.Color;

public class CarreAnimSimple extends Carre2D implements Animable {

    private float maxArete;
    private float minArete;
    private boolean agrandir = true;
    private static final float SPEED = 2.0f; // unités par seconde
    // TODO : ajuster la vitesse si besoin

    public CarreAnimSimple(float x, float y, float arete, Color color) {
        super(x, y, arete, color);
        this.maxArete = arete * 1.5f;
        this.minArete = arete * 0.5f;
    }

    @Override
    public void update(double deltaTime) {

        if (arete >= maxArete) {
            agrandir = false; ///rétrécir quand la taille max est atteinte
        } else if (arete <= minArete) {
            agrandir = true; // agrandir quand la taille min est atteinte
        }

        if (agrandir) {
            this.arete += SPEED * deltaTime;
        } else {
            this.arete -= SPEED * deltaTime;
        }

        calculePoints(); // recalcule les points du carré avec la nouvelle taille
    }
}