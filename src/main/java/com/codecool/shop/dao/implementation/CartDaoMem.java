package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDaoMem implements CartDao {
    private static CartDaoMem instance = null;
    private HashMap<Product, Integer> products = new HashMap<>();

    public static CartDaoMem getInstance () {
        if(instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public void addToCart (Product product) {
        if(products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    @Override
    public void removeFromCart (Product product) {
        if (products.get(product) > 1) {
            products.put(product, products.get(product) - 1);
        } else {
            products.remove(product);
        }
    }

    @Override
    public HashMap<Product, Integer> getProducts () {
        return this.products;
    }
}
