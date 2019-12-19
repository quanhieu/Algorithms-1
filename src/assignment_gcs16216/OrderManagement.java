package assignment_gcs16216;

import java.util.Scanner;

public class OrderManagement {

    public static void Run(MyProductList products, MyCustomerStack customers, MyOrderQueue orders) throws InputMismatchException {
        int select = -1;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                showMenu();
                select = sc.nextInt();
                switch (select) {
                    case 1:
                        orders.enqueue(inputData(products, customers));
                        break;
                    case 2:
                        display(orders, products);
                        break;
                    case 3:
                        // sort trong lớp của queue - sort trên danh sách (convert qua linked list - doubly linkedlist)
//				sortPcode();
                        orders.sortPcode();
                        System.out.println("All sorted");
                        
//                        show(orders, products);
//                        System.out.println("\nFINALLY");
                        display(orders, products);
                        break;
                    case 4:
                        // đổ ra mảng sort
                        orders.sortccode();
                        System.out.println("All sorted");
                        
//                        show(orders, products);
//                        System.out.println("\nFINALLY");
                        display(orders, products);
                        break;
                    case 5:
                        orders.mergeSort();
                        System.out.println("All sorted");
                        
//                        show(orders, products);
//                        System.out.println("\nFINALLY");
                        display(orders, products);
                        break;
                    case 6:
                        orders.mergeSortccode();
                        System.out.println("All sorted");
                        
//                        show(orders, products);
//                        System.out.println("\nFINALLY");
                        display(orders, products);
                        break;
                    default:
                        System.out.println("Please input 0-4");
                        break;
                }
            } catch (Exception e) {
                System.out.println("PLEASE INPUT AGAIN");
                sc.nextLine();
            }
        } while (select != 0);
    }

    private static void display(MyOrderQueue orders, MyProductList products) {
        Order top = orders.dequeue();
        if (top == null) {
            System.out.println("There is no order");
            return;
        }
        int i = 1;
        System.out.println("Order: " + i + top + "\n - Total: " + top.getQuantity() * products.find(top.getPcode()).getPrice());
        orders.enqueue(top);

        do {
            Order next = orders.dequeue();
            if (next == top) {
                orders.enqueue(next);
                break;
            }
            i++;
            System.out.println("Order: " + i + next + "\n - Total: " + next.getQuantity() * products.find(next.getPcode()).getPrice());
            orders.enqueue(next);

            // View sort
            
            //END view sort
        } while (true);
    }
    
    private static void show(MyOrderQueue orders, MyProductList products) {
        Order top1 = orders.dequeue();
        if (top1 == null) {
            System.out.println("There is no order");
            return;
        }
        int i = 1;
        System.out.println("Order: " + i + top1 + "\n - Total: " + top1.getQuantity() * products.find(top1.getPcode()).getPrice());
        orders.enqueue(top1);

        do {
            Order next = orders.dequeue();
            System.out.println("Order: " + i + next + "\n - Total: " + next.getQuantity() * products.find(next.getPcode()).getPrice());
            if (next == top1) {
                orders.enqueue(next);
                break;
            }
            System.out.println("==================================================");
            System.out.println("Step " +i);
            i++;
            System.out.println("Order: " + i + next + "\n - Total: " + next.getQuantity() * products.find(next.getPcode()).getPrice());
            orders.enqueue(next);
            
            // View sort
            System.out.println("Order: " + i + next + "\n - Total: " + next.getQuantity() * products.find(next.getPcode()).getPrice());
            //END view sort
        } while (true);
    }

    private static Order inputData(MyProductList products, MyCustomerStack customers) {
        // xử lý enter cho thoát ra ra ngoài
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInput new order: ");

        Order order = new Order();
        String pcode, ccode;

        System.out.print("Enter pcode: ");
        // Product
        do {
            pcode = sc.nextLine();
            if (findProduct(products, pcode)) {
                order.setPcode(pcode);
            } else {
                System.out.print("Invalid pcode. enter pcode again: ");
            }
        } //while(order.getPcode() !=null);
        while (order.getPcode() == null);

        // Customer
        System.out.print("Enter ccode: ");
        do {
            ccode = sc.nextLine();
            if (findCustomer(customers, ccode)) {
                order.setCcode(ccode);
            } else {
                System.out.print("Invalid pcode. enter ccode again: ");
            }
        } while (order.getCcode() == null);

        int quantity;
//		System.out.println("Enter quantity: ");
//		quantity = sc.nextInt();
//		order.setQuantity(quantity);

//        System.out.print("Enter quantity: ");
//        do {
//            quantity = Integer.parseInt(sc.nextLine());
//            if (checkQuantity(products.find(pcode), quantity)) {
//                order.setQuantity(quantity);
//            } else {
//                System.out.print("Invalid quantity. enter quantity again: ");
//            }
//        } while (order.getQuantity() == 0);

        
        while (true) {
            System.out.print("Quantity: ");
            String t = sc.nextLine();
            Product p = new Product();
            
            if (t.isEmpty()) {
                System.out.println("Quantity must be required!");
            } else if(p.getQuantity() > Integer.parseInt(t)){
                System.out.println("The number of products is not enough!");
            }else {
                order.setQuantity(Integer.parseInt(t));
                break;
            }
        }
        
        
        return order;
    }


//	private static boolean checkQuantity(MyProductList products, String pcode, int quantity) {
//		return products.findQuantity(products.find(pcode), quantity) !=null;
//	}
    private static boolean findCustomer(MyCustomerStack stack, String ccode) {
        boolean found = false;

        MyCustomerStack stack2 = new MyCustomerStack();
        while (!stack.isEmpty()) {
            Customer c = stack.pop();
            if (c.getCcode().equals(ccode)) {
                found = true;
            }
            stack2.push(c);
        }
        while (!stack2.isEmpty()) {
            Customer c = stack2.pop();
            stack.push(c);
        }
        return found;

    }

    private static boolean findProduct(MyProductList products, String pcode) {
        return products.find(pcode) != null;
    }

    private static void showMenu() {
        System.out.println("\nOrder managerment");
        System.out.println("===============================");
        System.out.println("1. Input data");
        System.out.println("2. Display data with total");
        System.out.println("3. Sort pcode");
        System.out.println("4. Sort ccode");
        System.out.println("5. Merge sort by pcode");
        System.out.println("6. Merge sort by ccode");
        System.out.println("0. Exit");
        System.out.println("===============================");
        System.out.println("\nEnter your choice: ");
    }
}
