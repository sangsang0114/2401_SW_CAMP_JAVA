class Arms {
    int energy;

    public void run() {
        energy--;
    }
}

class CleanArms extends Arms {
    @Override
    public void run() {
        super.run();
        System.out.println("팔로 청소를 합니다.");
    }
}

class BattleArms extends Arms {
    @Override
    public void run() {
        super.run();
        System.out.println("팔로 전투를 합니다.");
    }
}

class Robot {
    private Arms a;

    public Robot(Arms a) {
        this.a = a;
    }

    public void move() {
        a.run();
    }
}

public class RobotEx {
    public static void main(String[] args) {
        Robot hasCleanArms = new Robot(new CleanArms());
        Robot hasBattleArms = new Robot(new BattleArms());

        hasCleanArms.move();
        hasBattleArms.move();
    }
}
