package lab03;

import java.util.ArrayList;

public class CarTest {
    static ArrayList<Car> cars = new ArrayList<Car>();

    public static void main(String[] args) {
        boolean isSuccess;
        isSuccess = addCar(new Sonata("nf001"));
        printMsg(isSuccess);

        isSuccess = addCar(new Sonata("nf002"));
        printMsg(isSuccess);

        isSuccess = addCar(new Sonata("nf001"));
        printMsg(isSuccess);

        isSuccess = addCar(new Sonata("nf002"));
        printMsg(isSuccess);
    }

    static boolean addCar(Car c) {
        if (searchCar(c.toString()) == null) {
            cars.add(c);
            return true;
        } else {
            return false;
        }
    }

    static Car searchCar(String id) {
        for (Car c : cars) {
            if (c.id.equals(id))
                return c;
        }
        return null;
    }

    static void printMsg(boolean flag) {
        if (flag) System.out.println(" 성공");
        else System.out.println(" 실패");
    }
}
