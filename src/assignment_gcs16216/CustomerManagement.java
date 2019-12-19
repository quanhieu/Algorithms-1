package assignment_gcs16216;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerManagement {
    // MyCustomerStack list = new MyCustomerStack();

    public static MyCustomerStack Run(MyCustomerStack stack) throws InputMismatchException {
        int select = -1;
        Scanner sc = new Scanner(System.in);
//		MyCustomerStack stack = null;
        do {
            try {
                showMenu();
                select = sc.nextInt();
                switch (select) {
                    case 1:
                        stack = loadData();
                        break;
                    case 2:
                        if (stack == null) {
                            stack = new MyCustomerStack();
                        }
                        stack.push(inputCustomer());
                        break;
                    case 3:
                        display(stack);
                        break;
                    case 4:
                        savaData(stack);
                        break;
                    case 5:
                        searchCustomer(stack);
                        break;
                    case 6:
                        deleteCustomer(stack);
                        break;
                    default:
                        System.out.println("Please input 0-6");
                        break;
                }
            } catch (Exception e) {
                System.out.println("PLEASE INPUT AGAIN");
                sc.nextLine();
            }
        } while (select != 0);
        return stack;
    }

    private static void searchCustomer(MyCustomerStack stack) {
        Customer c;
        MyCustomerStack stack2 = new MyCustomerStack();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ccode to find: ");
        String ccode = sc.nextLine();
        while (!stack.isEmpty()) {
            stack2.push(stack.top());
            stack.pop();
        }
        while (!stack2.isEmpty()) {
            if (ccode.compareTo(stack2.top().getCcode()) == 0) {
                c = stack2.pop();
                stack.push(c);
                System.out.println(c);
            } else {
                stack.push(stack2.pop());
            }
        }
    }

    private static void deleteCustomer(MyCustomerStack stack) {
        MyCustomerStack stack2 = new MyCustomerStack();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ccode to delete: ");
        String ccode = sc.nextLine();
        while (!stack.isEmpty()) {
            stack2.push(stack.top());
            stack.pop();
        }
        while (!stack2.isEmpty()) {
            if (ccode.compareTo(stack2.top().getCcode()) == 0) {
                stack2.pop();
            } else {
                stack.push(stack2.pop());
            }
        }
        System.out.println("Stack has deleted");
    }

    private static Customer inputCustomer() {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();

//        System.out.println("Input Ccode: ");
//        String ccode = sc.next();
//        c.setCcode(ccode);
        while (true) {
            System.out.print("Customer id: ");
            String t = sc.next();
            if (t.isEmpty() || t.length() != 3) {
                System.out.println("Wrong customer id, please input 3 digit!");
            } else {
                c.setCcode(t);
            }
            sc.nextLine();
            break;

        }

//        System.out.println("Input Cname: ");
//        String cname = sc.next();
//        c.setC_name(cname);
        while (true) {
            System.out.print("Customer name: ");
            String t = sc.nextLine();
            if (t.isEmpty() || t.length() <= 10) {
                System.out.println("Customer name must more 10 character");
            } else {
                c.setC_name(t);
                break;
            }
        }

//        System.out.println("Input Phone: ");
//        String phone = sc.next();
//        c.setPhone(phone);
    while (true) {
            System.out.print("Customer phone: ");
            String t = sc.nextLine();
            if (t.isEmpty()) {
                System.out.println("Phone must be required");
            } else if (!t.isEmpty() && t.length() < 10 || t.length() > 11) {
                System.out.println("Phone must 10 or 11 number");
            } else if (!t.isEmpty() && t.length() == 10 || t.length() == 11) {
                c.setPhone(t);
                break;
            }
        }
    
        return c;
    }

    private static void savaData(MyCustomerStack stack) {
        System.out.println("Enter file name: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));

            MyCustomerStack stack2 = new MyCustomerStack();
            while (!stack.isEmpty()) {
                Customer c = stack.pop();
                stack2.push(c);
            }
            while (!stack2.isEmpty()) {
                Customer c = stack2.pop();
                writer.print("- ");
                writer.println(c);
                stack.push(c);
            }

            writer.close();
            System.out.println("Data has saved!!!");
        } catch (IOException e) {
            System.out.println("Cannot open file!!!");
        }

    }

    // day~ qua day~ lai
    private static void display(MyCustomerStack stack) {
        MyCustomerStack stack2 = new MyCustomerStack();
        while (!stack.isEmpty()) {
            Customer c = stack.pop();
            stack2.push(c);
        }
        while (!stack2.isEmpty()) {
            Customer c = stack2.pop();
            System.out.println(c);
            stack.push(c);
        }
    }

    private static MyCustomerStack loadData() {
        System.out.println("Enter file name: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        MyCustomerStack stack = new MyCustomerStack();

        try {
            Scanner file = new Scanner(new FileReader(filename));

            Customer customer = null;
            while (file.hasNext()) {
                String data = file.nextLine();

                if (data.charAt(0) == '-') {
                    if (customer != null) {
                        stack.push(customer);
                    }

                    customer = new Customer();
                    data = data.substring(1).trim();
                }

                String[] d2 = data.trim().split(":");
                d2[0] = d2[0].trim();
                d2[1] = d2[1].trim();
                if (d2[0].trim().equals("ccode")) {
                    customer.setCcode(d2[1]);
                }
                if (d2[0].trim().equals("cname")) {
                    customer.setC_name(d2[1]);
                }
                if (d2[0].equals("phone")) {
                    customer.setPhone(d2[1]);
                }
            }
            if (customer != null) {
                stack.push(customer);
            }
            file.close();
            System.out.println("Customer loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        }
        return stack;
    }

    private static void showMenu() {
        System.out.println("SMS management system");
        System.out.println("===============================");
        System.out.println("1. Load data from file");
        System.out.println("2. Add new item");
        System.out.println("3. Display data");
        System.out.println("4. Save data to file");
        System.out.println("5. Search by ccode");
        System.out.println("6. Delete by ccode");
        System.out.println("0. Exit");
        System.out.println("===============================");
        System.out.println("\nEnter your choice: ");
    }
}
