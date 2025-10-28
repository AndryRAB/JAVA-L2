package infographie.obj3d;

import infographie.CoordsRepere;

//CHECK : modifier la superclasse, car on ne veux pas déssiner le point. Utiliser plutôt CoordsRepere 

public class Point3D extends CoordsRepere {

    private float z;

    public Point3D(float xR, float yR, float zR) {
        super(xR, yR);

        this.z = zR;
    }

    public CoordsRepere projection2D() {
        // Distance focale pour contrôler la perspective
        float f = 10.0f;

        // Si le point est derrière la caméra, on le projette quand même mais très loin
        float zProjection = z <= 0 ? 0.1f : z;

        // Projection perspective avec distance focale
        float xProjected = (this.getxR() * f) / (zProjection + f);
        float yProjected = (this.getyR() * f) / (zProjection + f);

        return new CoordsRepere(xProjected, yProjected);
    }

    // #region Rotation

    public Point3D rotateX(double alpha) {
        float yprime = (float) (Math.cos(alpha) * super.getyR() - z * Math.sin(alpha));
        float zprime = (float) (Math.sin(alpha) * super.getyR() + z * Math.cos(alpha));

        return new Point3D(super.getxR(), yprime, zprime);
    }

    public Point3D rotateY(double alpha) {
        float xprime = (float) (Math.cos(alpha) * super.getxR() + z * Math.sin(alpha));
        float zprime = (float) (-Math.sin(alpha) * super.getxR() + z * Math.cos(alpha));

        return new Point3D(xprime, super.getyR(), zprime);
    }

    public Point3D rotateZ(double alpha) {
        float xprime = (float) (Math.cos(alpha) * super.getxR() - super.getyR() * Math.sin(alpha));
        float yprime = (float) (Math.sin(alpha) * super.getxR() + super.getyR() * Math.cos(alpha));

        return new Point3D(xprime, yprime, z);
    }
    // #endregion

    public Point3D translate(Point3D t) {
        return new Point3D(super.getxR() + t.getxR(), super.getyR() + t.getyR(), z + t.getZ());
    }

    public static Point3D sub(Point3D a, Point3D b) {
        return new Point3D(a.getxR() - b.getxR(), a.getyR() - b.getyR(), a.getZ() - b.getZ());
    }

    public static Point3D produitScalair(Point3D a, float n) {
        return new Point3D(a.getxR() * n, a.getyR() * n, a.getZ() * n);
    }

    // #region GetterSetter
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    // #endregion

}
