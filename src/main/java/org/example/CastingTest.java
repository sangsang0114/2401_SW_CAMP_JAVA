package org.example;

interface A {
}

interface B {
}

class C implements A, B {
}

class D extends C {
}

class CastingTest {
    public static void main(String[] args) {
        A a = new D();     // 묵시적 upcasting   OK
        // D d = new C() ;   // 묵시적 downcasting 컴파일 오류
        D d = (D) new C(); // 명시적 downcasting 컴파일 oK (무조건)
        // 실행은?   될 수 있고, 안될 수 있는데,  이 예제는 실행 안됨.

        int i = 10;
        long l = i;
        short s = (short) i;  // 명시적 캐스팅
    }
}