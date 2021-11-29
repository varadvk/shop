package com.eclinical.shop.runner;

import com.eclinical.shop.Exception.ProductNotFoundException;
import com.eclinical.shop.model.Order;
import com.eclinical.shop.model.User;
import com.eclinical.shop.service.ProductService;
import com.eclinical.shop.service.UserService;

import java.util.List;
import java.util.Scanner;

public class CustomerRunner implements Runner {

    private final User currentUser;

    Scanner scanner = new Scanner(System.in);

    ProductService productService = new ProductService();

    UserService userService = new UserService();

    public CustomerRunner(User user) {
        this.currentUser = user;
    }

    @Override
    public void runner() {
        try {
            boolean flag = true;
            while (flag) {
                System.out.println("1. Show all products\n2. Order new product\n3. Show all orders\n4. Logout");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        showAllProducts();
                        break;
                    case 2:
                        showAllProducts();
                        initiateOrder();
                        break;
                    case 3:
                        showAllOrders();
                        break;
                    case 4:
                        flag = false;
                        break;
                    default:
                        System.out.println("Incorrect choice");
                        break;
                }
            }
        } catch (ProductNotFoundException e) {
            System.err.println(e);
            runner();
        }
    }

    private void initiateOrder() {
        System.out.println("Please enter product id");
        int productId = Integer.parseInt(scanner.nextLine());

        productService.findByProductId(productId);

        System.out.println("Please enter quantity that you require");
        int quantity = Integer.parseInt(scanner.nextLine());

        productService.orderProduct(currentUser.getUsername(), productId, quantity);
    }

    private void showAllOrders() {
        List<Order> orders = userService.findOrderByUsername(currentUser.getUsername());

        userService.printOrders(orders);
    }

}
