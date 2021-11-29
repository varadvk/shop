package com.eclinical.shop.service;

import com.eclinical.shop.Exception.ProductNotFoundException;
import com.eclinical.shop.model.Customer;
import com.eclinical.shop.model.Order;
import com.eclinical.shop.model.Product;
import com.eclinical.shop.model.User;
import com.eclinical.shop.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private static final String ORDER_STATUS_DELIVERED = "Delivered";

    private static final String ORDER_STATUS_UNDELIVERED = "Undelivered";

    private static Integer orderId = 1;

    ProductRepository productRepository = new ProductRepository();

    UserService userService = new UserService();

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public Product findByProductId(Integer productId) {
        return productRepository.findByProductId(productId).orElseThrow(() -> new ProductNotFoundException("Invalid product id"));
    }

    public void orderProduct(String username, Integer productId, Integer quantity) {
        Product product = findByProductId(productId);

        Double orderAmount = product.getProductPrice() * quantity;

        Order order = new Order(orderId++, product, quantity, orderAmount, ORDER_STATUS_UNDELIVERED);

        Customer customer = (Customer) userService.findByUsername(username);

        List<Order> currentOrders = customer.getOrders();
        currentOrders.add(order);
        customer.setOrders(currentOrders);

        userService.save(customer);

    }

    public void markOrderAsDelivered(Integer orderId) {
        List<User> users = userService.findAllUsers();
        for (User user : users) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                for (Order order : customer.getOrders()) {
                    if (order.getOrderId().equals(orderId)) {
                        order.setOrderStatus(ORDER_STATUS_DELIVERED);
                        break;
                    }
                }
            }
        }
    }

    public void deleteProduct(int productId) {
        productRepository.deleteProduct(productId);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
