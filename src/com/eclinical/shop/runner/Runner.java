package com.eclinical.shop.runner;

import com.eclinical.shop.model.Customer;
import com.eclinical.shop.model.Order;
import com.eclinical.shop.model.Product;
import com.eclinical.shop.model.User;
import com.eclinical.shop.repository.ProductRepository;
import com.eclinical.shop.repository.UserRepository;

import java.util.List;
import java.util.Set;

public interface Runner {

    ProductRepository productRepository = new ProductRepository();

    UserRepository userRepository = new UserRepository();

    public static final String ORDER_STATUS_UNDELIVERED = "Undelivered";

    public static final String ORDER_STATUS_DELIVERED = "Delivered";

    void runner();

    default void showAllProducts() {
        Set<Product> products = productRepository.findAll();

        System.out.println("Here are all available products\n");
        System.out.println("Product Id\tProduct Name\tPrice");
        System.out.println("--------------------------------");
        for (Product product : products) {
            System.out.println(product.getProductId() + "\t\t\t" + product.getProductName() + "\t\t" + product.getProductPrice());
        }
        System.out.println("--------------------------------\n");
    }

    default void showOrders() {
        List<User> userOrders = userRepository.findAllOrders();

        if (userOrders.isEmpty()) {
            System.out.println("No any orders!!");
        } else {
            System.out.println("Here are all order details");
            System.out.println("Order Id\tCustomer name\tCustomer address\tCustomer contact number\tProduct Id\tProduct Name\tPrice\tQuantity\tOrder Amount\tStatus");
            System.out.println("-----------------------------------------------------------------");
            for (User user : userOrders) {
                Customer customer = (Customer) user;
                for (Order order : customer.getOrders()) {
                    System.out.println(order.getOrderId() + "\t\t" + customer.getName() + "\t\t" + customer.getAddress() + "\t\t" + customer.getContactNumber() + "\t\t" + order.getProduct().getProductId() + "\t\t" + order.getProduct().getProductName() + "\t\t" + order.getProduct().getProductPrice() + "\t\t" + order.getProductQuantity() + "\t\t" + order.getOrderAmount() + "\t\t" + order.getOrderStatus());
                }

            }
            System.out.println("-----------------------------------------------------------------\n\n");
        }
    }

    default void showUndeliveredOrders() {
        List<User> userOrders = userRepository.findAllOrders();

        if (userOrders.isEmpty()) {
            System.out.println("No any orders!!");
        } else {
            System.out.println("Here are all order details");
            System.out.println("Order Id\tCustomer name\tCustomer address\tCustomer contact number\tProduct Id\tProduct Name\tPrice\tQuantity\tOrder Amount\tStatus");
            System.out.println("-----------------------------------------------------------------");
            for (User user : userOrders) {
                Customer customer = (Customer) user;
                for (Order order : customer.getOrders()) {
                    if (order.getOrderStatus().equals(ORDER_STATUS_UNDELIVERED)) {
                        System.out.println(order.getOrderId() + "\t\t" + customer.getName() + "\t\t" + customer.getAddress() + "\t\t" + customer.getContactNumber() + "\t\t" + order.getProduct().getProductId() + "\t\t" + order.getProduct().getProductName() + "\t\t" + order.getProduct().getProductPrice() + "\t\t" + order.getProductQuantity() + "\t\t" + order.getOrderAmount() + "\t\t" + order.getOrderStatus());
                    }
                }
            }
            System.out.println("-----------------------------------------------------------------\n\n");
        }
    }

    default void showDeliveredOrders() {
        List<User> userOrders = userRepository.findAllOrders();

        if (userOrders.isEmpty()) {
            System.out.println("No any orders!!");
        } else {
            System.out.println("Here are all order details");
            System.out.println("Order Id\tCustomer name\tCustomer address\tCustomer contact number\tProduct Id\tProduct Name\tPrice\tQuantity\tOrder Amount\tStatus");
            System.out.println("-----------------------------------------------------------------");
            for (User user : userOrders) {
                Customer customer = (Customer) user;
                for (Order order : customer.getOrders()) {
                    if (order.getOrderStatus().equals(ORDER_STATUS_DELIVERED)) {
                        System.out.println(order.getOrderId() + "\t\t" + customer.getName() + "\t\t" + customer.getAddress() + "\t\t" + customer.getContactNumber() + "\t\t" + order.getProduct().getProductId() + "\t\t" + order.getProduct().getProductName() + "\t\t" + order.getProduct().getProductPrice() + "\t\t" + order.getProductQuantity() + "\t\t" + order.getOrderAmount() + "\t\t" + order.getOrderStatus());
                    }
                }

            }
            System.out.println("-----------------------------------------------------------------\n\n");
        }
    }

}
