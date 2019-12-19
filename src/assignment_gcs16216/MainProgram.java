/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_gcs16216;

import java.io.IOException;
import java.util.Scanner;

/**
 * check case 1
 *
 * @author Windows 10 TIMT
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InputMismatchException {
        // TODO code application logic here
        int select = -1;
        Scanner sc = new Scanner(System.in);
        MyProductList products = null;
        MyCustomerStack customers = null;

        MyOrderQueue orders = new MyOrderQueue();
        do {
            try {
                showMainMenu();
                select = sc.nextInt();
                switch (select) {
                    case 1:
                        products = ProductManagement.Run(products);
                        break;
                    case 2:
                        customers = CustomerManagement.Run(customers);
                        break;
                    case 3:
                        OrderManagement.Run(products, customers, orders);
                        break;
                    default:
                        System.out.println("Please input 0-3");
                        break;
                }
            } catch (Exception e) {
                System.out.println("PLEASE INPUT DIGIT");
                sc.nextLine();
            }
        } while (select != 0);
        System.out.println("See you later");
    }

    private static void showMainMenu() {
        System.out.println("SMS management system");
        System.out.println("===============================");
        System.out.println("1. Manage products");
        System.out.println("2. Manage customer");
        System.out.println("3. Manage order");
        System.out.println("0. Exit");
        System.out.println("===============================");
        System.out.println("\nEnter your choice: ");
    }
}
