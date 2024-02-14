package lab02;

public class DriveableRobotTest {
    public static void main(String[] args) {
        Palisade palisade = new Palisade();
        Morning morning = new Morning();

        DriveableRobot robot = new DriveableRobot();

        robot.drive(palisade);
        robot.drive(morning);
    }
}
