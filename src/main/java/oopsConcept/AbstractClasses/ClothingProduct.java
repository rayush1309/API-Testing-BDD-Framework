package oopsConcept.AbstractClasses;

// Concrete subclass representing a Clothing product
public class ClothingProduct extends Product {
    private String size;

    // Constructor
    public ClothingProduct(String name, double price, String size) {
        //super(name, price);
        super(name, price);
        this.size = size;
    }

    // Implementation of the abstract method to get the product type
    @Override
    public String getProductType() {
        return "Clothing";
    }

    // Implementation of the abstract method to calculate the discounted price
    @Override
    public double calculateDiscount() {
        // Specific logic for calculating discount for clothing products
        return getPrice() * 0.15; // 15% discount
    }

    // Additional methods specific to ClothingProduct
    public String getSize() {
        return size;
    }

    // Method to print product details
    public void printProductDetails() {
        System.out.println("Product Type: " + getProductType());
        System.out.println("Name: " + getName());
        System.out.println("Size: " + size);
        System.out.println("Price: $" + getPrice());
        System.out.println("Discounted Price: $" + (getPrice() - calculateDiscount()));
    }

    public static void main(String[] args) {
        // Creating an instance of ClothingProduct with appropriate parameters
        ClothingProduct clothingProduct = new ClothingProduct("T-Shirt", 29.99, "Medium");

        // Calling the printProductDetails method on the instance
        clothingProduct.printProductDetails();
    }
}
