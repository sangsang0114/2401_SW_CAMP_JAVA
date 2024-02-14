package org.example;

// 추상클래스
// abstract class : 객체 생성 못함. (추상메소드와 일반메소드 모두 포함 가능)
// 추상 메소드가 하나라도 있으면 반드시 추상 클래스이어야 함
// 추상 클래스라고 해서 추상메소드가 꼭 있어야 하는 것은 아님.
abstract class Shape { //  객체가 될 만큼 충분한 정보 없는 클래스를 추상클래스로 생성
    abstract void draw();
    //추상메소드 : 구현할 만큼 충분한 정보가 없을 때 추상메소드로 생성
}

class Circle extends Shape {
    void draw() {
    }
}

class Rectangle extends Shape {
    void draw() {
    }
}

public class AbstractClassTest {
    public static void main(String[] args) {
        //Shape s = new Shape();  // 오류  abstract class의 객체 생성 못함.

    }
}