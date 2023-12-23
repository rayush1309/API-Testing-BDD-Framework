package oopsConcept.Encapsulation;

public class EcommerceProduct {
    public static void main(String[] args) {
        // Creating an instance of the Product class
        Product laptop = new Product("Laptop", 999.99);

        // Displaying initial product details
        laptop.displayProductDetails();

        // Modifying availability
        laptop.setAvailable(false);

        // Displaying updated product details
        laptop.displayProductDetails();
    }

}
