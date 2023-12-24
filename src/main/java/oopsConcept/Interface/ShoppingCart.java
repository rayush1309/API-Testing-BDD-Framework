package oopsConcept.Interface;

public class ShoppingCart implements EcommerceInterface {
    private double totalPrice;  // Added field to store the total price

    @Override
    public void addItemToCart(String itemName, double price, int quantity) {
        System.out.println(quantity + " " + itemName + " added to the cart at $" + price + " each.");
        // Adjust the total price based on the added item
        totalPrice += price * quantity;
    }

    @Override
    public double calculateTotalPrice() {
        System.out.println("Calculating total price...");
        return totalPrice;
    }

    @Override
    public void placeOrder() {
        System.out.println("Order placed successfully!");
        System.out.println("Thank you for shopping with us!");
        // Additional actions can be performed here, such as updating inventory or generating an order confirmation
    }

}
