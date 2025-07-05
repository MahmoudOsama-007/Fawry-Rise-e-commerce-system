import Service.CheckoutService;
import model.Cart;
import model.Customer;
import model.product.ExpiryDate;
import model.product.FixedWeight;
import model.product.Product;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //weight in g
        Product cheese = new Product("Cheese", 100, 10, new FixedWeight("Cheese", 200), new ExpiryDate(LocalDate.of(2025, 7, 20)));
        Product tv = new Product("TV", 500, 5, new FixedWeight("TV", 5000), null);
        Product scratchCard = new Product("ScratchCard", 50, 20, null, null);

        Customer customer = new Customer("Ali", 1000);
        Cart cart = new Cart();
        cart.addItem(cheese, 2);
        cart.addItem(tv, 1);
        cart.addItem(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}
