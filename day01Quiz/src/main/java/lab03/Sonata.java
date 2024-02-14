package lab03;

public class Sonata extends Car {
    public Sonata(String id) {
        super(id);
    }

    @Override
    void run() {
        System.out.println("Sonata가 달린다");
    }

    @Override
    public String toString() {
        return this.id;
    }
}
