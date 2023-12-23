package oopsConcept.Inheritance;

// Main class
public class Automotive {

    public static void main(String[] args) {
        // Creating a car and displaying its information
        Car car = new Car("Toyota", "Camry", 2022, 4);
        car.displayCarInfo();

        // Creating a motorcycle and displaying its information
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR500R", 2022, true);
        motorcycle.displayMotorcycleInfo();

        // Creating a car with an engine and demonstrating engine methods
        CarWithEngine carWithEngine = new CarWithEngine("Ford", "Mustang", 2022, 2);
        carWithEngine.displayCarInfo();
        carWithEngine.start();
        carWithEngine.stop();

        // Creating a motorcycle with an engine and demonstrating engine methods
        MotorcycleWithEngine motorcycleWithEngine = new MotorcycleWithEngine("Harley-Davidson", "Street Glide", 2022, false);
        motorcycleWithEngine.displayMotorcycleInfo();
        motorcycleWithEngine.start();
        motorcycleWithEngine.stop();
    }

    // Base class
    static class Vehicle {
        private String make;
        private String model;
        private int year;

        public Vehicle(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        // Getters and setters

        public void displayInfo() {
            System.out.println("Vehicle: " + year + " " + make + " " + model);
        }
    }

    // Subclass for cars
    static class Car extends Vehicle {
        private int numberOfDoors;

        public Car(String make, String model, int year, int numberOfDoors) {
            super(make, model, year);
            this.numberOfDoors = numberOfDoors;
        }

        // Additional methods for cars

        public void displayCarInfo() {
            displayInfo();
            System.out.println("Number of Doors: " + numberOfDoors);
        }
    }

    // Subclass for motorcycles
    static class Motorcycle extends Vehicle {
        private boolean hasFairing;

        public Motorcycle(String make, String model, int year, boolean hasFairing) {
            super(make, model, year);
            this.hasFairing = hasFairing;
        }

        // Additional methods for motorcycles

        public void displayMotorcycleInfo() {
            displayInfo();
            System.out.println("Has Fairing: " + hasFairing);
        }
    }

    // Engine Interface
    // An interface Engine that defines methods for starting and stopping the engine.
    interface Engine {
        void start();

        void stop();
    }

    // Car and Motorcycle Implementing Engine Interface
    // Both Car and Motorcycle implement the Engine interface
    static class CarWithEngine extends Car implements Engine {
        public CarWithEngine(String make, String model, int year, int numberOfDoors) {
            super(make, model, year, numberOfDoors);
        }

        @Override
        public void start() {
            System.out.println("Car engine started.");
        }

        @Override
        public void stop() {
            System.out.println("Car engine stopped.");
        }
    }

    static class MotorcycleWithEngine extends Motorcycle implements Engine {
        public MotorcycleWithEngine(String make, String model, int year, boolean hasFairing) {
            super(make, model, year, hasFairing);
        }

        @Override
        public void start() {
            System.out.println("Motorcycle engine started.");
        }

        @Override
        public void stop() {
            System.out.println("Motorcycle engine stopped.");
        }
    }
}
