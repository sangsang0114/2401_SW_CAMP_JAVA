package org.example;


public class DynamicBindingTest {
    public static void drive(Car c) { // Genesis is a Car.  Sonata is a Car.
        // Polymorphism 다형성
        c.run(); // run 메소득가 인스턴스 메소드이므로 1) 동적( 실행 시 ) 바인딩.
        // run 메소득가 static 메소드라면 2) 정적 (컴파일 시 )바인딩 .

        // c 가 Genesis 면  자동주차기능을 호출.
        if (c instanceof Genesis) {
//           c.autoPark() ;  //오류
            Genesis gg = (Genesis) c; // 명시적 Downcasting
            gg.autoPark();
        }
    }

    public static void main(String[] args) {
        Genesis g = new Genesis();
        Sonata s = new Sonata();

        // Polymorphism 다형성
        drive(g); // Car c = g ; // 묵시적 UPCASTING은 언제나 OK.
        drive(s); // Car c = s ; // 묵시적 UPCASTING은 언제나 OK.
    }
}

class Car {
    void run() {
        System.out.println(" Car RUN ");
    }
}

class Sonata extends Car {
    void run() {
        System.out.println(" SONATA RUN ");
    }
}

class Genesis extends Car {
    void run() {
        System.out.println(" Genesis RUN ");
    }

    void autoPark() {
        System.out.println(" Genesis autoPark ");
    }
}