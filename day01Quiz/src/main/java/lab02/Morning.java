package lab02;

public class Morning extends Car {
    @Override
    public void run() {
        System.out.println("Morning 움직이기 시작");
    }

    @Override
    public void stop() {
        System.out.println("Morning 정지");
    }

    @Override
    public void turnRight() {
        System.out.println("45 각도로 우회전e");
    }

    @Override
    public void turnLeft() {
        System.out.println("45 각도로 좌회전");
    }
}
