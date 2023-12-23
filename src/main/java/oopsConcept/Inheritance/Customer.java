package oopsConcept.Inheritance;
//Customer Class Hierarchy:
//Base class Customer with common attributes and methods.
//Subclasses RegularCustomer and PremiumCustomer inheriting from Customer.
public class Customer {
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and setters

    public void displayInfo() {
        System.out.println("Customer: " + name);
        System.out.println("Address: " + address);
    }
}

// Subclass for regular customers
class RegularCustomer extends Customer {
    public RegularCustomer(String name, String address) {
        super(name, address);
    }
    // Additional methods for regular customers
}

// Subclass for premium customers
class PremiumCustomer extends Customer {
    public PremiumCustomer(String name, String address) {
        super(name, address);
    }
    // Additional methods for premium customers


}
