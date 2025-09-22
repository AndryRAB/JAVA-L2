package infographie.data;

public class Transformation {

    public static EqCart sinusoidal(EqCart E, float vitesse, float amplitude) {

        float nextX = E.getX() + vitesse;
        float nextY = (float) (Math.cos(nextX) * amplitude);
        return new EqCart(nextX, nextY);
    }

}
