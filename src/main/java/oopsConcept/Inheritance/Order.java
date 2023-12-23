package oopsConcept.Inheritance;

import java.util.List;

//Order Class:
//Order class representing a customer's order, which can contain multiple products.
public class Order {
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public void displayOrderDetails() {
        customer.displayInfo();
        System.out.println("Order Details:");
        for (Product product : products) {
            product.displayInfo();
        }
    }

}

/*
Explanation of Inheritance Concepts:
Single Inheritance:

ElectronicProduct and ClothingProduct inherit from the Product class.
RegularCustomer and PremiumCustomer inherit from the Customer class.
MultiLevel Inheritance:

The class hierarchy involves multiple levels. For example, ElectronicProduct inherits from Product, and RegularCustomer inherits from Customer.
Hierarchical Inheritance:

Both ElectronicProduct and ClothingProduct inherit from the same base class, Product.
Similarly, RegularCustomer and PremiumCustomer inherit from the same base class, Customer.
Composition (Order Class):

The Order class has a composition relationship with the Customer and Product classes.
Interfaces:

Interfaces may not be explicitly shown in this example, but you could introduce interfaces like Discountable for products or RewardsProgram for customers.
 */