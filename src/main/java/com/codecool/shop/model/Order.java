package com.codecool.shop.model;

import java.util.Date;
import java.util.List;

public class Order {
    private final int id;
    private final Date date;
    private  final double totalPrice;
    private  String billingAddress;
    private  String shippingAddress;
    private  final Cart cart;

    public Order(int id, Date date, double totalPrice, String billingAddress, String shippingAddress, Cart cart) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public List<LineItem> getAllItemsFromCart(){
        return cart.getItems();
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
