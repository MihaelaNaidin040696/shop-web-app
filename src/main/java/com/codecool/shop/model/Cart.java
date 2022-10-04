package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<LineItem> items = new ArrayList<>();


    public void addToCart(LineItem itemToAdd) {
        if(items.contains(itemToAdd)) {
            LineItem existingItem = items.get(items.indexOf(itemToAdd));
            existingItem.setQuantity(existingItem.getQuantity() + 1);
        } else {
            itemToAdd.setQuantity(1);
            items.add(itemToAdd);
        }
    }

    public void removeItem(LineItem itemToRemove) {

    }
}
