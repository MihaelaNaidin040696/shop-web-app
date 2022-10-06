package com.codecool.shop.model;

import java.util.Date;

public class Order extends BaseModel {
    private final int id;
    private final Date date;
    private final double totalPrice;
    private final Cart cart;
    private String billingAddress;
    private String shippingAddress;

    public Order (String name, String description, int id, Date date, double totalPrice, String billingAddress, String shippingAddress, Cart cart) {
        super(name, description);
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.cart = cart;
    }

    public int getId () {
        return id;
    }
}
