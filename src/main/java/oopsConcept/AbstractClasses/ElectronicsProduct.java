package oopsConcept.AbstractClasses;

// Concrete subclass representing an Electronics product
public class ElectronicsProduct extends Product {
    private int warrantyPeriod;

    // Constructor
    public ElectronicsProduct(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    // Implementation of the abstract method to get the product type
    @Override
    public String getProductType() {
        return "Electronics";
    }

    // Implementation of the abstract method to calculate the discounted price
    @Override
    public double calculateDiscount() {
        // Specific logic for calculating discount for electronics products
        return getPrice() * 0.1; // 10% discount
    }

    // Additional methods specific to ElectronicsProduct
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public static void main(String[] args) {
        ElectronicsProduct electronicsProduct= new ElectronicsProduct("Ayush", 100, 2);
        electronicsProduct.printProductDetails();
    }
    public void printProductDetails() {
        System.out.println("Product Type: " + getProductType());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Discounted Price: $" + (getPrice() - calculateDiscount()));
    }
}
