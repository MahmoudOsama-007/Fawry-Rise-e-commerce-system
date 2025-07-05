package model;

import model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();
    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product,quantity));
    }
    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() { // New method
        return items.isEmpty();
    }
    public int getQuantity(String name) {
       for (CartItem item : items) {
           if (item.getProduct().getName().equals(name)) {
               return item.getQuantity();
           }
       }
       throw new RuntimeException("No product with name " + name + " found");
    }
}
