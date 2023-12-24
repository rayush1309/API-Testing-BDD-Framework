package oopsConcept.AbstractClasses;

// Concrete subclass representing a Book product
public class BookProduct extends Product {
    private String author;

    // Constructor
    public BookProduct(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    // Implementation of the abstract method to get the product type
    @Override
    public String getProductType() {
        return "Book";
    }

    // Implementation of the abstract method to calculate the discounted price
    @Override
    public double calculateDiscount() {
        // Specific logic for calculating discount for book products
        return getPrice() * 0.12; // 12% discount
    }

    // Additional methods specific to BookProduct
    public String getAuthor() {
        return author;
    }

    // Method to print product details
    public void printProductDetails() {
        System.out.println("Product Type: " + getProductType());
        System.out.println("Name: " + getName());
        System.out.println("Author: " + author);
        System.out.println("Price: $" + getPrice());
        System.out.println("Discounted Price: $" + (getPrice() - calculateDiscount()));
    }

    public static void main(String[] args) {
        // Creating an instance of BookProduct
        BookProduct book = new BookProduct("Java Programming", 49.99, "John Doe");

        // Calling the printProductDetails method on the instance
        book.printProductDetails();
    }
}
