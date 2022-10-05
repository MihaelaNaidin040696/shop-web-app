package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartDaoMem implements CartDao {

    private HashMap<Product,Integer> cartProducts = new HashMap<>();
    private List<LineItem> items = new ArrayList<>();
    private static CartDaoMem instance = null;

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    public List<LineItem> getItems() {
        return items;
    }

    @Override
    public void addToCart (LineItem itemToAdd) {
        if(items.contains(itemToAdd)) {
            LineItem existingItem = items.get(items.indexOf(itemToAdd));
            existingItem.setQuantity(existingItem.getQuantity() + 1);
        } else {
            itemToAdd.setQuantity(1);
            items.add(itemToAdd);
        }
    }

    public void addToCartt(Product product){
        if(cartProducts.containsKey(product)){
            cartProducts.put(product, cartProducts.get(product)+1);
        }
        else{
            cartProducts.put(product,1);
        }
    }

    @Override
    public void removeItem (LineItem itemToRemove) {
        items.remove(itemToRemove);
    }

    @Override
    public void decreaseQuantity (LineItem item) {
        if(items.contains(item)){
            LineItem existingItem = items.get(items.indexOf(item));
            existingItem.setQuantity(existingItem.getQuantity() - 1);
        }
    }

    @Override
    public void clearCart () {
        items.clear();
    }

    @Override
    public int sizeOfCart () {
        return items.size();
    }

    @Override
    public List<LineItem> getAll() {
        return items;
    }

    public HashMap<Product, Integer> getCartProducts() {
        return this.cartProducts;
    }
}
