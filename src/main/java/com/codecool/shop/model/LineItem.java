package com.codecool.shop.model;

public class LineItem {
    Product product;
    int quantity;
    private int id;

    public LineItem (Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

    }

    @Override
    public String toString () {
        return "LineItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", id=" + id +
                '}';
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public Product getProduct () {
        return product;
    }

    public void setProduct (Product product) {
        this.product = product;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }
}
