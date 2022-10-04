package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<LineItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<LineItem> getItems () {
        return items;
    }
}
