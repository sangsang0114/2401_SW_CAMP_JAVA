package lab02;

public class Palisade extends Car implements AutoParkable {
    @Override
    public void run() {
        System.out.println("소나타가 움직이기 시작");
    }

    @Override
    public void stop() {
        System.out.println("소나타가 정지");
    }

    @Override
    public void turnRight() {
        System.out.printf("%d 각도로 우회전\n", getAngle());
    }

    @Override
    public void turnLeft() {
        System.out.printf("%d 각도로 좌회전\n", getAngle());
    }


    @Override
    public void autoPark() {
        System.out.println("자동 주차");
    }
}
