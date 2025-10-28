package infographie.obj3d;

import java.awt.Color;

public class RotatingElement3D extends Element3D {
    private double speedX = 0;
    private double speedY = 0;
    private double speedZ = 0;

    public RotatingElement3D(float x, float y, float z, Color color) {
        super(x, y, z, color);
    }

    public void addRotationSpeed(double speedX, double speedY, double speedZ) {
        this.speedX += speedX;
        this.speedY += speedY;
        this.speedZ += speedZ;
    }

    @Override
    public void update(double deltaTime) {
        this.selfRotateY(speedY * deltaTime);
        this.selfRotateX(speedX * deltaTime);
        this.selfRotateZ(speedZ * deltaTime);
    }

    // #region GETTER_SETTER
    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public double getSpeedZ() {
        return speedZ;
    }

    public void setSpeedZ(double speedZ) {
        this.speedZ = speedZ;
    }
    // #endregion

}
