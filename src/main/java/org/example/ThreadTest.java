package org.example;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadEx1 threadEx1 = new ThreadEx1();
        threadEx1.start();

        ThreadEx2 threadEx2 = new ThreadEx2();
        threadEx2.start();

        threadEx1.join();
        threadEx2.join();

        System.out.println("Main 종료");
    }
}

class ThreadEx3 implements Runnable {

    @Override
    public void run() {

    }
}

class ThreadEx2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            setName("yourThread");
            System.out.println(i + " " + getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ThreadEx1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            setName("myThread");
            System.out.println(i + " " + getName());
            try {
                Thread.sleep(110);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}