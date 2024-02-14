package lab02;

abstract public class Car {
    private int angle;

    abstract public void run();

    abstract public void stop();

    abstract public void turnRight();

    abstract public void turnLeft();

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
