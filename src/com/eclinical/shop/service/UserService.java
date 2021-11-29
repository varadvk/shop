package com.eclinical.shop.service;

import com.eclinical.shop.Exception.UserNotFoundException;
import com.eclinical.shop.model.Customer;
import com.eclinical.shop.model.Order;
import com.eclinical.shop.model.User;
import com.eclinical.shop.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new UserNotFoundException("Incorrect credentials"));
    }

    public User findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Incorrect username"));
    }

    public void save(Customer customer) {
        userRepository.save(customer);
    }

    public List<Order> findOrderByUsername(String username) {
        Customer customer = (Customer) userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("Incorrect username"));
        return customer.getOrders();
    }

    public void printOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("You have not ordered anything yet!!");
        } else {
            System.out.println("Here are your order details");
            System.out.println("Order Id\tProduct Id\tProduct Name\tPrice\tQuantity\tOrder Amount\tStatus");
            System.out.println("-----------------------------------------------------------------");
            for (Order order : orders) {
                System.out.println(order.getOrderId() + "\t\t" + order.getProduct().getProductId() + "\t\t" + order.getProduct().getProductName() + "\t\t" + order.getProduct().getProductPrice() + "\t\t" + order.getProductQuantity() + "\t\t" + order.getOrderAmount() + "\t\t" + order.getOrderStatus());
            }
            System.out.println("-----------------------------------------------------------------\n\n");
        }
    }

}
