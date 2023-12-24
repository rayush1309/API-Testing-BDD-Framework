package oopsConcept.Interface;

public class EcommerceApp {
    public static void main(String[] args) {
        // Example usage of the ShoppingCart class
        ShoppingCart cart = new ShoppingCart();

        // Adding items to the cart
        cart.addItemToCart("Mobile", 50, 2);
        cart.addItemToCart("Laptop", 100, 1);

        // Calculating total price
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Total Price: $" + totalPrice);

        // Placing the order
        cart.placeOrder();
    }

}
