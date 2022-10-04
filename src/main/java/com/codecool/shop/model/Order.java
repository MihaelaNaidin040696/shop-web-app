package com.codecool.shop.model;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date date;
    private double totalPrice;
    private String billingAddress;
    private String shippingAddres;
    private Cart cart;


    public Order(int id, double totalPrice, String billingAddress, String shippingAddres) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.billingAddress = billingAddress;
        this.shippingAddres = shippingAddres;
        this.cart = new Cart();
    }

    public List<LineItem> getAllItemsFromCart(){
        return cart.getItems();
    }
}
