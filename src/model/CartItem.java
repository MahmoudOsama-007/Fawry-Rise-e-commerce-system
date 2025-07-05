package model;

import model.product.Product;

public class CartItem {
    int quantity;
    Product product;

    public CartItem(Product product , int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
