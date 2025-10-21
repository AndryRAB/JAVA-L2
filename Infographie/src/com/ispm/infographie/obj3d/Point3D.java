package infographie.obj3d;

import java.awt.Color;

import infographie.Point;

//TODO : modifier la superclasse, car on ne veux pas déssiner le point. Utiliser plutôt CoordsRepere 

public class Point3D extends Point {

    private float z;

    public Point3D(float xR, float yR, float zR, Color c) {
        super(xR, yR, 'o', c);

        this.z = zR;
    }

    @Override
    public float getxR() {
        if (z <= 0)
            return super.getxR();
        return super.getxR() / z;
    }

    @Override
    public float getyR() {
        if (z <= 0)
            return super.getyR();
        return super.getyR() / z;
    }

    public Point3D rotateX(double alpha) {
        float yprime = (float) (Math.cos(alpha) * super.getyR() - z * Math.sin(alpha));
        float zprime = (float) (Math.sin(alpha) * super.getyR() + z * Math.cos(alpha));

        return new Point3D(super.getxR(), yprime, zprime,  this.color);
    }

    public Point3D rotateY(double alpha) {
        float xprime = (float) (Math.cos(alpha) * super.getxR() + z * Math.sin(alpha));
        float zprime = (float) (-Math.sin(alpha) * super.getxR() + z * Math.cos(alpha));

        return new Point3D(xprime, super.getyR(), zprime, this.color);
    }

    public Point3D rotateZ(double alpha) {
        float xprime = (float) (Math.cos(alpha) * super.getxR() - super.getyR() * Math.sin(alpha));
        float yprime = (float) (Math.sin(alpha) * super.getxR() + super.getyR() * Math.cos(alpha));

        return new Point3D(xprime, yprime, z,  this.color);
    }

    public Point3D translate(int x, int y, int z) {
        return new Point3D(super.getxR() + x, super.getyR() + y, z,  this.color);
    }

}
