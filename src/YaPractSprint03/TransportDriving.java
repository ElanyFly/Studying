package YaPractSprint03;

public class TransportDriving {
    public static void main(String[] args) {
        DriftCar driftCar = new DriftCar(true, 2);
        Car car = new Car(false, 5);
        Bike bike = new Bike();

        Driver driver = new Driver();
        driver.drive(bike);
        driver.drive(car);
        driver.drive(driftCar);
    }
}

class Vehicle {
    int doorsCount;
    boolean isBenzine;

    Vehicle(boolean isBenzine, int doorsCount) {
        this.isBenzine = isBenzine;
        this.doorsCount = doorsCount;
    }

    void drive() {
        System.out.println("Врум-врум");
    }
}

class Car extends Vehicle {
    Car(boolean isBenzine, int doorsCount) {
        super(isBenzine, doorsCount);
    }
}

class DriftCar extends Car {
    DriftCar(boolean isBenzine, int doorsCount) {
        super(isBenzine, doorsCount);
    }

    void drift() {
        System.out.println("Еду боком!");
    }
}

class Bike extends Vehicle {
    Bike() {
        super(true, 0);
    }

    void rideOnBackWheel() {
        System.out.println("Еду на заднем колесе!");
    }
}

class Driver {
    public void drive(Vehicle vehicle) {
        if (vehicle instanceof DriftCar) {
            ((DriftCar) vehicle).drift();
        } else if (vehicle instanceof Bike) {
            ((Bike) vehicle).rideOnBackWheel();
        } else {
            vehicle.drive();
        }
    }
}