package oopsConcept.AbstractClasses;

    // Abstract class representing a product in an e-commerce system
    public abstract class Product {
        private String name;
        private double price;

        // Constructor
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Abstract method to get the product type
        public abstract String getProductType();

        // Abstract method to calculate the discounted price
        public abstract double calculateDiscount();

        // Getter methods
        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }





