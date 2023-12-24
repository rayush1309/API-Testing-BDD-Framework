package oopsConcept.Interface;

public interface EcommerceInterface {
   // Method to add an item to the shopping cart
    void addItemToCart(String itemName, double price, int quantity);

    // Method to calculate the total price of items in the shopping cart
    double calculateTotalPrice();

    // Method to place an order and perform any necessary actions
    void placeOrder();

}
