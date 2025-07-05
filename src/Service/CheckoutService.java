package Service;


import model.Cart;
import model.CartItem;
import model.Customer;
import model.product.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {

        if (cart.isEmpty()) {
            throw new RuntimeException("Cannot checkout an empty cart.");
        }

        double subtotal = 0;
        double totalWeight = 0;
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            if (p.isExpired()) throw new RuntimeException(p.getName() + " is expired");
            if (p.getQuantity() < qty) throw new RuntimeException("Insufficient stock for " + p.getName());

            p.reduceQuantity(qty);
            subtotal += p.getPrice() * qty;

            if (p.isShippable()) {
                final String shippableName = p.getName();
                final double totalItemWeight = p.getWeight() * qty;
                totalWeight+=totalItemWeight;
                Shippable shippable = new FixedWeight(shippableName, totalItemWeight);
                shippableItems.add(shippable);
            }
        }
        double shippingCost =0;

        System.out.println("\n** Shipment notice **");

        if (shippableItems.isEmpty()) {
            System.out.println("No shippable items found.");
        } else{
            shippingCost=ShippingService.calculateShippingCost(shippableItems);
            for (Shippable shippable : shippableItems) {
                int quantity= cart.getQuantity(shippable.getName());
                System.out.printf("%dx %s %.0f\n", quantity, shippable.getName(), shippable.getWeight());
            }
            System.out.printf("Total package weight %.1fkg\n",totalWeight/1000);
        }



        double amount = subtotal + shippingCost;
        customer.pay(amount);

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            int qty = item.getQuantity();
            String name=item.getProduct().getName();
            double totalPrice=item.getProduct().getPrice() * qty;
            System.out.printf("%dx %s %.0f\n", qty, name, totalPrice);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingCost);
        System.out.printf("Amount %.0f\n", amount);
        System.out.printf("Remaining balance: %.0f\n", customer.getBalance());
    }
}
