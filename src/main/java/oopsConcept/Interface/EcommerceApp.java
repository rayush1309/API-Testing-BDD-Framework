package oopsConcept.Interface;

public class EcommerceApp {
    public static void main(String[] args) {
        // Example usage of the ShoppingCart class
        ShoppingCart cart = new ShoppingCart();

        // Adding items to the cart
        cart.addItemToCart("Product Mobile", 100, 2);
        cart.addItemToCart("Product Laptop", 109, 1);

        // Calculating total price
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Total Price: $" + totalPrice);

        // Placing the order
        cart.placeOrder();
    }

}
