package lab02;

public class DriveableRobot implements Driveable {
    @Override
    public void drive(Car r) {
        r.run();
        r.turnRight();
        r.turnLeft();
        r.stop();
        if (r instanceof AutoParkable)
            ((AutoParkable) r).autoPark();
    }
}
