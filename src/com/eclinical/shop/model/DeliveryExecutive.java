package com.eclinical.shop.model;

public class DeliveryExecutive extends User {

    private final String deliveryExecutiveRole;

    public DeliveryExecutive(String name, String contactNumber, String address, String username, String password) {
        super(name, contactNumber, address, username, password);
        this.deliveryExecutiveRole = "DELIVERY EXECUTIVE";
    }
}
