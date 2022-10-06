package com.codecool.shop.dao;

import com.codecool.shop.model.Order;

import java.util.List;

public interface OrderDao {

    Order find (int id);

    Object addInformationFromUser (String info);

    void add (Order order);

    List<String> getInfoUser ();

    int getId ();

    void addOrders (Order orderToAdd);

    void clearOrder ();
}
