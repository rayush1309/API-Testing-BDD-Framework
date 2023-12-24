package oopsConcept.Interface;

public class MultipleInheritance {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.start();
        sedan.drive();
        sedan.stop();
        sedan.park();
        sedan.printInfo();

        SportsBike sportsBike = new SportsBike();
        sportsBike.start();
        sportsBike.accelerate();
        sportsBike.stop();
        sportsBike.brake();
        sportsBike.printInfo();

        DeliveryTruck deliveryTruck = new DeliveryTruck();
        deliveryTruck.start();
        deliveryTruck.loadCargo();
        deliveryTruck.stop();
        deliveryTruck.unloadCargo();
        deliveryTruck.printInfo();
    }

    // Interface for common vehicle features
    interface Vehicle {
        void start();
        void stop();
        void printInfo();
    }

    // Interface for features specific to cars
    interface Car extends Vehicle {
        void drive();
        void park();
    }

    // Interface for features specific to motorcycles
    interface Motorcycle extends Vehicle {
        void accelerate();
        void brake();
    }

    // Interface for features specific to trucks
    interface Truck extends Vehicle {
        void loadCargo();
        void unloadCargo();
    }

    // Common methods for print information
    interface Printable {
        default void printInfo(String message) {
            System.out.println(message);
        }
    }

    // Static inner class representing a Car
    static class Sedan implements Car, Printable {
        @Override
        public void start() {
            printInfo("Sedan started.");
        }

        @Override
        public void stop() {
            printInfo("Sedan stopped.");
        }

        @Override
        public void drive() {
            printInfo("Sedan is driving.");
        }

        @Override
        public void park() {
            printInfo("Sedan is parked.");
        }

        @Override
        public void printInfo() {
            printInfo("Printing information about Sedan.");
        }
    }

    // Static inner class representing a Motorcycle
    static class SportsBike implements Motorcycle, Printable {
        @Override
        public void start() {
            printInfo("Sports bike started.");
        }

        @Override
        public void stop() {
            printInfo("Sports bike stopped.");
        }

        @Override
        public void accelerate() {
            printInfo("Sports bike is accelerating.");
        }

        @Override
        public void brake() {
            printInfo("Sports bike is braking.");
        }

        @Override
        public void printInfo() {
            printInfo("Printing information about Sports Bike.");
        }
    }

    // Static inner class representing a Truck
    static class DeliveryTruck implements Truck, Printable {
        @Override
        public void start() {
            printInfo("Delivery truck started.");
        }

        @Override
        public void stop() {
            printInfo("Delivery truck stopped.");
        }

        @Override
        public void loadCargo() {
            printInfo("Loading cargo in the delivery truck.");
        }

        @Override
        public void unloadCargo() {
            printInfo("Unloading cargo from the delivery truck.");
        }

        @Override
        public void printInfo() {
            printInfo("Printing information about Delivery Truck.");
        }
    }
}


/*
In this example, we have interfaces Vehicle, Car, Motorcycle,
and Truck representing common and specific features of vehicles. Concrete classes Sedan, SportsBike, and
DeliveryTruck implement these interfaces, demonstrating the use of multiple inheritance through interfaces in an
Automotive project.
 */