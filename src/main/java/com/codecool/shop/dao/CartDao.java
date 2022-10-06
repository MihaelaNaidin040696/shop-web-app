package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

import java.util.HashMap;

public interface CartDao {
    void addToCart (Product product);

    void removeFromCart (Product product);

    HashMap<Product, Integer> getProducts ();
}
