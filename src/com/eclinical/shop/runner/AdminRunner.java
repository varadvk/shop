package com.eclinical.shop.runner;

import com.eclinical.shop.model.Product;
import com.eclinical.shop.service.ProductService;

import java.util.Scanner;

public class AdminRunner implements Runner {

    private static Integer productId = 4;
    Scanner scanner = new Scanner(System.in);
    ProductService productService = new ProductService();

    @Override
    public void runner() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Show all products\n2. Delete product\n3. Add new product\n4. Update product details\n5. Show all orders\n6. Show all un-delivered orders\n7. Show all delivered orders\n8. Logout");
            int choice = Integer.parseInt(scanner.nextLine());

            AdminRunner adminRunner = new AdminRunner();
            switch (choice) {
                case 1:
                    adminRunner.showAllProducts();
                    break;
                case 2:
                    adminRunner.showAllProducts();
                    deleteProduct();
                    break;
                case 3:
                    saveProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    showOrders();
                    break;
                case 6:
                    showUndeliveredOrders();
                    break;
                case 7:
                    showDeliveredOrders();
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }

    private void deleteProduct() {
        System.out.println("Enter product id to delete product");
        int productId = Integer.parseInt(scanner.nextLine());

        productService.deleteProduct(productId);

    }

    private void saveProduct() {

        System.out.println("Enter product name");
        String productName = scanner.nextLine();

        System.out.println("Enter product price");
        Double productPrice = Double.parseDouble(scanner.nextLine());

        Product product = new Product(productId++, productName, productPrice);

        productService.saveProduct(product);
    }

    private void updateProduct() {
        System.out.println("Enter product id");
        int productId = Integer.parseInt(scanner.nextLine());

        Product product = productService.findByProductId(productId);

        System.out.println("If you want to update product name then press y else n");
        String choice = scanner.nextLine();

        if (choice.equals("y") || choice.equals("Y")) {
            System.out.println("Enter new name");
            String productName = scanner.nextLine();
            product.setProductName(productName);
        }

        System.out.println("If you want to update product price then press y else n");
        choice = scanner.nextLine();

        if (choice.equals("y") || choice.equals("Y")) {
            System.out.println("Enter new price");
            Double productPrice = Double.parseDouble(scanner.nextLine());
            product.setProductPrice(productPrice);
        }

        productService.saveProduct(product);
    }

}
