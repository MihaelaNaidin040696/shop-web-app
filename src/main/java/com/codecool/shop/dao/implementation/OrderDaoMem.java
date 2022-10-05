package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoMem implements OrderDao {

    private String name;
    private String address;
    private int id;
    private Order order;

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
    public Object addInformationFromUser(String info) {
            infoUser.add(info);
        return null;
    }

    @Override
    public void add(Order order) {
        order.setId(data.size()+1);
        data.add(order);
    }

    public List<String> getInfoUser() {
        return infoUser;
    }

    public void addOrders (Order orderToAdd) {
        if(!data.contains(orderToAdd)){
            data.add(orderToAdd);
        }
    }

    @Override
    public void clearOrder() {
        infoUser.clear();
    }

    @Override
    public int getId() {
        return id;
    }
}
