package org.example;

public class ConstructorTest {
    public static void main(String[] args) {
        Emp one = new Emp("kim");
        Emp two = new Emp();

        Member member = new Member(0);
        System.out.println(member.i);

        Child child = new Child();
    }
}

class Emp {
    String name;

    public Emp() {

    }

    public Emp(String name) {
        this.name = name;
    }
}

class Member {
    int i = 10;

    Member(int i) {
        this.i = i;
    }
}

class Parent {
    Parent() {
        System.out.println("Parent Constructor");
    }

    Parent(int i) {
        System.out.println("Parent(int i) Constructor");
    }
}

class Child extends Parent {
    Child() {
        super(100);
        System.out.println("Child Constructor");
    }
}