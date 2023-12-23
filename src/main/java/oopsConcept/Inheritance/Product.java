package oopsConcept.Inheritance;
//// Base class
//Base class Product with common attributes and methods.
//Subclasses ElectronicProduct and ClothingProduct inheriting from Product
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and setters

    public void displayInfo() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
    }
}

// Subclass for electronic products
class ElectronicProduct extends Product {
    private String brand;

    public ElectronicProduct(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    // Additional methods for electronic products
}

// Subclass for clothing products
class ClothingProduct extends Product {
    private String size;

    public ClothingProduct(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    // Additional methods for clothing products


}
