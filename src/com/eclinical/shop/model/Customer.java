package com.eclinical.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private List<Order> orders;
    private String customerRole;

    public Customer(String name, String contactNumber, String address, String username, String password, List<Order> orders) {
        super(name, contactNumber, address, username, password);
        this.orders = orders;
        this.customerRole = "customer";
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "orders=" + orders +
                ", customerRole='" + customerRole + '\'' +
                '}';
    }


    public List<Order> getOrders() {
        if (orders == null) {
            return new ArrayList<Order>();
        }
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
