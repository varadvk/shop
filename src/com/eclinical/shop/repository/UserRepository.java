package com.eclinical.shop.repository;

import com.eclinical.shop.model.Admin;
import com.eclinical.shop.model.Customer;
import com.eclinical.shop.model.DeliveryExecutive;
import com.eclinical.shop.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static List<User> users = new ArrayList<>();

    static {
        User adminUser = new Admin("admin", "1111111111", "Mumbai", "admin", "admin", "1111111111", "Pune");
        User deliveryExecutiveUser = new DeliveryExecutive("Delivery", "4444444444", "Mumbai", "delivery", "delivery");
        User customer1 = new Customer("Varadraj Kulkarni", "2222222222", "Delhi", "varad", "varad", null);
        User customer2 = new Customer("Raj Patil", "3333333333", "Kolkata", "raj", "raj", null);

        users.add(adminUser);
        users.add(deliveryExecutiveUser);
        users.add(customer1);
        users.add(customer2);
    }

    public List<User> findAllUsers() {
        return users;
    }

    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public void save(Customer customer) {
        users.removeIf(u -> u.getUsername().equals(customer.getUsername()));
        users.add(customer);
    }

    public List<User> findAllOrders() {
        List<User> userOrders = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                if (!customer.getOrders().isEmpty()) {
                    userOrders.add(customer);
                }
            }
        }

        return userOrders;
    }

}
