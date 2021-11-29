package com.eclinical.shop.runner;

import com.eclinical.shop.Exception.ProductNotFoundException;
import com.eclinical.shop.service.ProductService;

import java.util.Scanner;

public class DeliveryExecutiveRunner implements Runner {

    Scanner scanner = new Scanner(System.in);

    ProductService productService = new ProductService();

    @Override
    public void runner() {
        try {
            boolean flag = true;
            while (flag) {
                System.out.println("1. Show all orders\n2. Show all undelivered orders\n3. Show all delivered orders\n4. Mark order as delivered\n5. Logout");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        showOrders();
                        break;
                    case 2:
                        showUndeliveredOrders();
                        break;
                    case 3:
                        showDeliveredOrders();
                        break;
                    case 4:
                        markOrderAsDelivered();
                        break;
                    case 5:
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

    private void markOrderAsDelivered() {
        showUndeliveredOrders();
        System.out.println("\nEnter order id");
        int orderId = Integer.parseInt(scanner.nextLine());
        productService.markOrderAsDelivered(orderId);
    }
}
