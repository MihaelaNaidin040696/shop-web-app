package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoMem implements OrderDao {

    private String name;
    private String address;

    private List<Order> data = new ArrayList<>();
    private List<String> infoUser = new ArrayList<>();

    private static OrderDaoMem instance = null;


    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getData() {
        return data;
    }

    public void setData(List<Order> data) {
        this.data = data;
    }

    public static void setInstance(OrderDaoMem instance) {
        OrderDaoMem.instance = instance;
    }

    @Override
    public Order find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addInformationFromUser(String info) {
            infoUser.add(info);
    }

    public List<String> getInfoUser() {
        return infoUser;
    }
}
