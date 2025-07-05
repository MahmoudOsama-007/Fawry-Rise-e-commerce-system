package model.product;

import java.time.LocalDate;

public class Product {
    private final String name;
    private final double price;
    private int quantity;
    private final Shippable shippable;
    private final Expirable expirable;


    public Product(String name, double price, int quantity, Shippable shippable, Expirable expirable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippable = shippable;
        this.expirable = expirable;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void reduceQuantity(int qty) {
        if (qty > quantity) {
            throw new RuntimeException("You cannot exceed the current quantity");
        }
        quantity -= qty;
    }
    public boolean isShippable() { return shippable != null; }
    public boolean isExpired() {
        return expirable != null && expirable.isExpired(LocalDate.now());
    }
    public double getWeight() { return isShippable() ? shippable.getWeight() : 0; }

}
