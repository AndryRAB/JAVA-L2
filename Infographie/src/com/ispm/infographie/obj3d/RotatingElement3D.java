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
    
}
