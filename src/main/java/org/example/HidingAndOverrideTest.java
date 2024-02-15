package org.example;

public class HidingAndOverrideTest {
    public static void main(String[] args) {
        Ch one = new Ch();
        System.out.println(one.p);
        one.mp();
    }
}

class P {
    int p = 10;

    void mp() {
        System.out.println("mp");
    }
}

class Ch extends P {
    int p = 20; //부모의 변수 p를 은닉

    @Override
    void mp() {
        System.out.println("mp in Ch");
        System.out.println(this.p);
        System.out.println(super.p);
    }
}
