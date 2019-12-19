/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_gcs16216;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author Windows 10 TIMT
 */
public class ProductManagement {

    MyProductList list = new MyProductList();

    public static MyProductList Run(MyProductList list) throws InputMismatchException {
        int select = -1;
        Scanner sc = new Scanner(System.in);
        //MyProductList list = null;
        do {
            try {
                showMenu();
                select = sc.nextInt();
                switch (select) {
                    case 1:
                        list = loadData();
                        break;
                    case 2:
                        if (list == null) {
                            list = new MyProductList();
                        }
                        list.addLast(inputProduct());
                        break;
                    case 3:
                        if (list != null) {
                            list.traverse();
                        }
                        break;
                    case 4:
                        saveData(list);
                        break;
                    case 5:
                        search(list);
                        break;
                    case 6:
                        deleteProduct(list);
                        break;
                    case 7:
                        // chuyển danh sách sang mảng rồi sort -> sau đó chuyển lại danh sách (đổ ra mảng rồi sort)
                        // sort trực tiếp trên danh sách liên kết 
                        // tạo danh sách mới rồi sách xếp

                        list.bsort();
                        System.out.println("Products sorted");
                        list.traverse();
                        break;
                    case 8:
                        deletetailx(list);
                        break;
                    case 9:
                        list.asort();
                        System.out.println("Products sorted by pname");
                        break;
                    case 10:
                        list.csort();
                        System.out.println("Products sorted by pcode");
                        list.traverse();
                        break;
                    default:
                        System.out.println("Please input 0-8");
                        break;
                }
            } catch (Exception e) {
                System.out.println("PLEASE INPUT AGAIN");
                sc.nextLine();
            }
        } while (select != 0);
        return list;

    }

    private static void search(MyProductList list) {
        System.out.println("Enter pcode to search: ");
        Scanner sc = new Scanner(System.in);
        String pcode = sc.next();
        if (list.searchPcode(pcode)) {
            System.out.println();
        } else {
            System.out.println("Product can not find");
        }
    }

    private static void deletetailx(MyProductList list) {
        System.out.println("Enter pcode to delete: ");
        Scanner sc = new Scanner(System.in);
        String pcode = sc.next();
        if (list.deleteTail(pcode)) {
            System.out.println("Product delete");
        } else {
            System.out.println("Product can not delete");
        }

    }

    private static void showMenu() {
        System.out.println("SMS management system");
        System.out.println("===============================");
        System.out.println("1. Load data from file");
        System.out.println("2. Add new item");
        System.out.println("3. Display data");
        System.out.println("4. Save data to file");
        System.out.println("5. Search by pcode");
        System.out.println("6. Delete by pcode");
        System.out.println("7. Sort by pcode use Insertion-sort");
        System.out.println("8. Delete the node after the node having code = xCode");
        System.out.println("9. Sort by pname use Merge-sort");
        System.out.println("10.Sort by pname use Quick-sort");
        System.out.println("0. Exit");
        System.out.println("===============================");
        System.out.println("\nEnter your choice: ");
    }

    private static void deleteProduct(MyProductList list) {
        System.out.println("Enter pcode to delete: ");
        Scanner sc = new Scanner(System.in);
        String pcode = sc.next();
        if (list.delete(pcode)) {
            System.out.println("Product delete");
        } else {
            System.out.println("Product can not delete");
        }
    }

    private static Product inputProduct() {
        Scanner sc = new Scanner(System.in);
        Product p = new Product();
        while (true) {
            System.out.print("Product id: ");
            String t = sc.next();
            if (t.isEmpty() || t.length() != 3) {
                System.out.println("Wrong product id, please input 3 digit!");
            } else {
                p.setPcode(t);
            }
            sc.nextLine();
            break;

        }

//        System.out.println("Nhập Pname: ");
//        String pname = sc.next();
//        p.setPname(pname);
        while (true) {
            System.out.print("Product name: ");
            String t = sc.nextLine();
            if (t.isEmpty() || t.length() <= 10) {
                System.out.println("Product name must more 10 character");
            } else {
                p.setPname(t);
                break;
            }
        }

//        System.out.println("Nhập quantity: ");
//        int quantity = sc.nextInt();
//        p.setQuantity(quantity);
        while (true) {
            System.out.print("Input quantity: ");
            String t = sc.next();
            if (t.isEmpty() || t.length() >= 20) {
                System.out.println("Input quantity again, quantity not more 20");
            } else {
                p.setQuantity(Integer.parseInt(t));
            }
            break;
        }

//        System.out.println("Nhập saled: ");
//        int saled = sc.nextInt();
//        p.setSaled(saled);
//        while (true) {
//            System.out.print("Input saled: ");
//            String t = sc.next();
//            if (t.isEmpty() || t.length() <= 20) {
//                System.out.println("Input saled again, saled not more 20");
//            } else {
//                p.setSaled(Integer.parseInt(t));
//            }
//            break;
//        }
        
        while (true) {
            System.out.print("Input saled: ");
            String t = sc.nextLine();
            if (t.isEmpty()) {
                System.out.println("Input saled again");
            } else if(p.getQuantity() > Integer.parseInt(t)){
                System.out.println("The number of saled must less quantity!");
            }else {
                p.setSaled(Integer.parseInt(t));
                break;
            }
        }

//        System.out.println("Nhập price: ");
//        double price = sc.nextDouble();
//        p.setPrice(price);
        while (true) {
            System.out.print("Input price: ");
            String t = sc.next();
            if (t.isEmpty()) {
                System.out.println("Input price again");
            } else {
                p.setPrice(Double.parseDouble(t));
            }
            break;
        }

        return p;
    }

    private static void saveData(MyProductList list) {
        System.out.println("Enter file name: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            list.reset();
            while (list.hasNext()) {
                writer.print("- ");
                writer.println(list.next());
            }
            writer.close();
            System.out.println("Data has saved!!!");
        } catch (IOException e) {
            System.out.println("Cannot open file!!!");
//			e.printStackTrace();
        }
    }

    private static MyProductList loadData() {
        System.out.println("Enter file name: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        MyProductList list = new MyProductList();
        try {
            Scanner file = new Scanner(new FileReader(filename));
            Product product = null;
            while (file.hasNext()) {
                String data = file.nextLine();
                if (data.charAt(0) == '-') {
                    if (product != null) {
                        list.addLast(product);
                    }
                    product = new Product();
                    data = data.substring(1).trim();
                }
                String[] d2 = data.trim().split(":");
                d2[0] = d2[0].trim();
                d2[1] = d2[1].trim();
                if (d2[0].trim().equals("pcode")) {
                    product.setPcode(d2[1]);
                }
                if (d2[0].trim().equals("pname")) {
                    product.setPname(d2[1]);
                }
                if (d2[0].equals("quantity")) {
                    product.setQuantity(Integer.parseInt(d2[1]));
                }
                if (d2[0].equals("saled")) {
                    product.setSaled(Integer.parseInt(d2[1]));
                }
                if (d2[0].equals("price")) {
                    product.setPrice(Double.parseDouble(d2[1]));
                }
            }
            if (product != null) {
                list.addLast(product);
            }
            file.close();
            System.out.println("Product loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        }
        return list;
    }

}
