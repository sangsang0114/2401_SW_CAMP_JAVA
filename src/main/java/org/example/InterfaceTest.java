package org.example;

import java.util.ArrayList;

// 인터페이스  :  (명명 규칙)명사 또는 형용사
// 메소드 : 추상 메소드만 포함 가능 (public abstract)
// 변수 :  public static final 즉, 상수만 포함 가능.
interface RemoteControllerCase {
    void on();    //public abstract 자동으로 붙음.

    void off();   //public abstract 자동으로 붙음.
}

class TVRemoteController implements RemoteControllerCase {
    public void on() {
        System.out.println("tv on ");
    }

    public void off() {
        System.out.println("tv off ");
    }
}

class DVDremoteController implements RemoteControllerCase {
    public void on() {
        System.out.println("DVD on ");
    }

    public void off() {
        System.out.println("DVD off ");
    }
}

class Robot {
    void powerOn(RemoteControllerCase r) {
        r.on();
    }

    void powerOff(RemoteControllerCase r) {
        r.off();
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        TVRemoteController r1 = new TVRemoteController();
        DVDremoteController r2 = new DVDremoteController();
        Robot robot = new Robot();
        robot.powerOn(r1);
        robot.powerOn(r2);
    }
}