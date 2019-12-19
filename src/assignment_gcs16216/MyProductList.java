/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_gcs16216;

import sun.invoke.empty.Empty;

/**
 *
 * @author Windows 10 TIMT
 */
public class MyProductList {

    Node<Product> node;
    MyList<Product> products;

    public MyProductList() {
        products = new MyList<Product>();
        node = null;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addLast(Product p) {
        products.addLast(p);
    }

    public Product removeLast() {
        return products.removeLast();
    }

    public void traverse() {
//		products.traverse();
        products.reTraverse(products.head);
    }

    public boolean hasNext() {
        return node != null;
    }

    public void reset() {
        node = products.head;
    }

    public Product next() {
        if (node == null) {
            return null;
        }
        Product t = node.info;
        node = node.next;
        return t;
    }

    public boolean delete(String pcode) {
        Node<Product> node = products.head;
        while (node != null) {
            if (node.info.getPcode().equals(pcode)) {
                break;
            }
            node = node.next;
        }
        if (node == null) {
            return false;
        }

        products.remove(node);
        return true;
    }

    public boolean deleteTail(String pcode) {
        Node<Product> node = products.head;
        while (node != null) {
            if (node.info.getPcode().equals(pcode)) {
                break;
            }
            node = node.next;
        }
        if (node == null) {
            return false;
        }

        products.remove(node.next);
        return true;
    }

//	public boolean insertSort(Product p, int n) {
//		for(int i=1; i<n; i++){
//            int tmp = p.getPcode();
//            int j=i-1;
//            while(j>=0 && p[j] >tmp){
//                p[j+1] = a[j];
//                j--;
//            }
//            a[++j] = tmp;
//        }
//	}
    // selection sort for list //
    public void sort() {
        Node<Product> node = products.head;
        Node<Product> head = null, tail = null;
        while (node != null) {
            Node<Product> min = node;
            Node<Product> node2 = node.next;
            while (node2 != null) {
                if (node2.info.getPcode().compareTo(min.info.getPcode()) < 0) {
                    min = node2;
                }
                node2 = node2.next;
            }

            products.remove(min);

            if (head == null) {
                head = tail = min;
                min.next = min.prev = null;
            } else {
                tail.next = min;
                tail = min;
                min.prev = tail;
                min.next = null;
            }

            node = products.head;
        }
        
        products.head = head;
        products.tail = tail;
    }

    // END sort list //
    // ============ CONVERT TO ARRAY ===================//
    // sort array
    public void asort() {
        Product a[] = new Product[products.size()];
        products.dump(a);
//		mergeSortArray(a);
        mergeSort(a);

        Product[] sortedArray = mergeSort(a);

        products = new MyList<Product>();
        products.addMany(a);

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println("- " + sortedArray[i] + " ");
        }
    }

    // tham khao selection sort slide -> so sanh pcode
//	private void mergeSortArray(Product[] a) {
//
//	}
    public Product[] mergeSort(Product[] pName) {
        Product[] sorted = new Product[pName.length];
        if (pName.length == 1) {
            sorted = pName;
        } else {
            int mid = pName.length / 2;
            Product[] left = null;
            Product[] right = null;
            if ((pName.length % 2) == 0) {
                left = new Product[pName.length / 2];
                right = new Product[pName.length / 2];
            } else {
                left = new Product[pName.length / 2];
                right = new Product[(pName.length / 2) + 1];
            }
            int x = 0;
            int y = 0;
            for (; x < mid; x++) {
                left[x] = pName[x];
            }
            for (; x < pName.length; x++) {
                right[y++] = pName[x];
            }
            left = mergeSort(left);
            right = mergeSort(right);
            sorted = mergeArray(left, right);
        }

        return sorted;
    }

    private Product[] mergeArray(Product[] left, Product[] right) {
        Product[] merged = new Product[left.length + right.length];
        int lIndex = 0;
        int rIndex = 0;
        int mIndex = 0;
        int comp = 0;
        while (lIndex < left.length || rIndex < right.length) {
            if (lIndex == left.length) {
                merged[mIndex++] = right[rIndex++];
            } else if (rIndex == right.length) {
                merged[mIndex++] = left[lIndex++];
            } else {
                comp = left[lIndex].compareTo(right[rIndex]);
                if (comp > 0) {
                    merged[mIndex++] = right[rIndex++];
                } else if (comp < 0) {
                    merged[mIndex++] = left[lIndex++];
                } else {
                    merged[mIndex++] = left[lIndex++];
                }
            }
        }
        return merged;
    }

    // *https://stackoverflow.com/questions/28855350/java-mergesort-for-objects-of-arraylist*//
//    public void printArray (Product [] a, int n){
//        StringBuilder sb = new StringBuilder("[");
//        for(int i =0; i<n-1; i++){
//            sb.append(a[i]).append(", ");
//        }
//        sb.append(a[n-1]).append(" ]");
//        System.out.println(sb.toString());
//    }
    // ======END convert to array===============//
    // INSERT array==========
    public void bsort() {
        Product a[] = new Product[products.size()];
        products.dump(a);
        insertSort(a);

        products = new MyList<Product>();
        products.addMany(a);

    }
    //http://www.letscodepro.com/insertion-sort/

    private Product[] insertSort(Product[] a) {

        Product temp;
        for (int i = 1; i < a.length; i++) {    // loop through the elements of array
            for (int j = i; j > 0; j--) {           // loop to find the appropriate location in the previous part of array
                if (a[j].compareToPcode(a[j - 1]) < 0) {          // if the  descending order violates

                    temp = a[j];                // swapping of elements
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            // View step
//            products = new MyList<Product>();
//            products.addMany(a);
//            System.out.println("Sorting insertion sort: " + i);
//            traverse();
//            System.out.println("=====================");
            // END View step
        }

        return a;
    }
    // END INSERT array==========

    // QUCIK SORT array==========
    //http://www.letscodepro.com/quick-sort-explanation-implementation-java/
    public void csort() {
        Product a[] = new Product[products.size()];
        products.dump(a);

        int low = 0;
        int high = a.length - 1;
        quickSort(a, low, high);

        products = new MyList<Product>();
        products.addMany(a);

    }
    //https://www.programcreek.com/2012/11/quicksort-array-in-java/

    private void quickSort(Product[] a, int low, int high) {
        if (a == null || a.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        // pick the pivot
        int middle = low + (high - low) / 2;
        Product pivot = a[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (a[i].compareToPcode(pivot) < 0) {
                i++;
            }

            while (a[j].compareToPcode(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                Product temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        // View step
//        products = new MyList<Product>();
//        products.addMany(a);
//        System.out.println("Sorting quick sort: ");
//        traverse();
//        System.out.println("=====================");
        // END View step

        // recursively sort two sub parts
        if (low < j) {
            quickSort(a, low, j);
        }

        if (high > i) {
            quickSort(a, i, high);
        }
    }

    // END quick sort array==========
    //=======================================
    public boolean searchPcode(String pcode) {
        Node<Product> node = products.head;
        while (node != null) {
            if (node.info.getPcode().equals(pcode)) {
                break;
            }
            node = node.next;
        }
        if (node == null) {
            return false;
        }

        System.out.println(node.info);
        return true;
    }

    public Product find(String pcode) {
        Node<Product> node = products.head;
        while (node != null) {
            if (node.info.getPcode().equals(pcode)) {
                return node.info;
            }
            node = node.next;
        }
        return null;
    }

//	public Product findQuantity(String pcode, int quantity) {
//		Node<Product> node = products.head;
//		while (node != null) {
//			if (node.info.getPcode().equals(pcode))
//			else if (node.info.getQuantity().equals())
//				return node.info;
//			node = node.next;
//			}
//		return null;
//	}
//////====================MERGE=SORT==============//////
//https://www.geeksforgeeks.org/merge-sort-for-doubly-linked-list/
//////==========END=SORT===========//////
}
