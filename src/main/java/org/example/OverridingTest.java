package org.example;

public class OverridingTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.move();

        Animal c = new Cat();
        c.move();
    }
}

class Animal {
    void move() {
        System.out.println("동물이 움직입니다. ");
    }
}

class Cat extends Animal {
    @Override
    void move() {
        System.out.println("고양이가 움직입니다. ");
    }
}
