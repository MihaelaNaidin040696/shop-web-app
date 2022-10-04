package com.codecool.shop.model;

public class LineItem {
    Product product;
    int quantity;

    public LineItem (Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct () {
        return product;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }
}
