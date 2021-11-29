import com.eclinical.shop.Exception.UserNotFoundException;
import com.eclinical.shop.model.Admin;
import com.eclinical.shop.model.Customer;
import com.eclinical.shop.model.DeliveryExecutive;
import com.eclinical.shop.model.User;
import com.eclinical.shop.runner.AdminRunner;
import com.eclinical.shop.runner.CustomerRunner;
import com.eclinical.shop.runner.DeliveryExecutiveRunner;
import com.eclinical.shop.runner.Runner;
import com.eclinical.shop.service.UserService;

import java.util.Scanner;

public class Main {

    private final UserService userService = new UserService();

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Main runner = new Main();
        runner.run();

    }

    private void run() {

        try {

            System.out.println("Welcome to the online shopping mart");
            System.out.println("------------------------------------");

            boolean flag = true;
            while (flag) {
                System.out.println();
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong choice");
                        break;
                }
            }
        } catch (UserNotFoundException e) {
            System.err.println(e + "\n");
            run();
        }
    }

    private void login() throws UserNotFoundException {
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();

        User user = userService.findByUsernameAndPassword(username, password);

        Runner runner = null;

        if (user instanceof Admin) {
            runner = new AdminRunner();
        } else if (user instanceof DeliveryExecutive) {
            runner = new DeliveryExecutiveRunner();
        } else {
            runner = new CustomerRunner(user);
        }

        runner.runner();
    }

    private void register() {
        System.out.println("Enter full name");
        String fullName = scanner.nextLine();
        System.out.println("Enter contact number");
        String contactNumber = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();

        Customer customer = new Customer(fullName, contactNumber, address, username, password, null);

        userService.save(customer);

    }


}
