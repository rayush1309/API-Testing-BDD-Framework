package oopsConcept.Encapsulation;

public class Product {
        private String productName;
        private double price;
        private boolean available;

        // Constructor
        public Product(String productName, double price) {
            this.productName = productName;
            this.price = price;
            this.available = true; // By default, a product is available
        }

        // Getter methods
        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        public boolean isAvailable() {
            return available;
        }

        // Setter method for availability
        public void setAvailable(boolean available) {
            this.available = available;
        }

        // Method to display product details
        public void displayProductDetails() {
            System.out.println("Product: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Availability: " + (available ? "Available" : "Out of Stock"));
        }



}
