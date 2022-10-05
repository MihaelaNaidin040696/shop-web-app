package com.codecool.shop.dao;

import com.codecool.shop.model.Order;

import java.util.List;

public interface OrderDao {

    Order find(int id);
    void addInformationFromUser(String info);

    List<String> getInfoUser();


}
