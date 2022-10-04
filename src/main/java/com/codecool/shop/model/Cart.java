package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<LineItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<LineItem> getItems () {
        return items;
    }

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
        items.remove(itemToRemove);
    }

    public void decreaseQuantity(LineItem item) {
        if(items.contains(item)){
            LineItem existingItem = items.get(items.indexOf(item));
            existingItem.setQuantity(existingItem.getQuantity() - 1);
        }
    }

    public void clearCart() {
        items.clear();
    }

    public int sizeOfCart() {
        return items.size();
    }
}
