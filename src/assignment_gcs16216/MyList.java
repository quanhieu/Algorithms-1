/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_gcs16216;



/**
 *
 * @author Windows 10 TIMT
 */
public class MyList<T> {
    Node<T> head, tail;
    public MyList(){
        head = tail = null;
    }
    
    public boolean isEmpty(){
        return (head ==null);
    }
    
    public void addLast(T x){
        if(isEmpty()){
            head = tail = new Node(x, null, null);
        }
        else{
            Node n = new Node(x, null, tail);
            tail.next = n;
            tail = n;
        } 
    }
    
    
 public T removeLast(){
        if(isEmpty())
            return null;
        if(head == tail){
            T info = tail.info;
            head = tail = null;
            return info;
        }
        T info = tail.info;
        tail = tail.prev;
        tail.next = null;
        return info;
    }
 
 
	public T removeFirst() {
		if(head == null)
			return null;
		T info = head.info;
		
		head = head.next;
		if(head !=null)
			head.prev = null;
		else
			tail = null;
		return info;
	}
    
      public void addMany(T[] a) {
        for (T i : a) {
            addLast(i);
        }
    }

      // lay du lieu ra
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            System.out.println();
            p = p.next;
        }
    }
    
    //de quy bang traver
    public void reTraverse(Node<T> node) {
    	if(node == null) 
    		return;
    	
    	System.out.println(node.info);
    	System.out.println();
    	reTraverse(node.next);
    }
    // End 
    
    public T removeT(){
        if(isEmpty())
            return null;
        if(head == tail){
           T info = tail.info;
           head = tail =null;
        return info;
        }
        T info = tail.info;
        tail = tail.prev;
        tail.next = null;
        return info;
    }
    
//    public void removeLast(){
//        if(isEmpty())
//            return;
//        if(head == tail){
//            head = tail = null;
//            
//        }
//        T info = tail.info;
//        tail = tail.prev;
//        tail.next = null;
//        
//    }

    public void deleteHead() {
        Node p;
        if (head != null) {
            p = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            if (p != null) {
                p.next = null;
            }
        }
    }
    
    // do du lieu vao day ?????
//    public void remove(Node<T> node)
    public void remove(Node<Product> node) {
    	if(node ==null) 
    		return;
       	if(node.prev != null)
    		node.prev.next = node.next;
    	else
    		head = node.next;
    	
    	if(node.next != null)
    		node.next.prev = node.prev;
    	else
    		tail = node.prev;
    }
    
    public void remove1(Node<Order> min) {
    	if(min ==null) 
    		return;
       	if(min.prev != null)
    		min.prev.next = min.next;
    	else
    		head = min.next;
    	
    	if(min.next != null)
    		min.next.prev = min.prev;
    	else
    		tail = min.prev;
    }

    //============ CONVERT TO ARRAY ===================//
	public int size() {
		int size = 0;
		Node p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
		return size;
	}

	public void dump(T[] a) {
		int size =0;
		Node<T> p = head;
        while (p != null) {
            a[size++] = p.info;
            p = p.next;
		
        }
	}

	
//===================END convert to array===================//
	
//////==========QUICH=SORT===========//////
//https://www.geeksforgeeks.org/quicksort-for-linked-list/
	
//////==========END=SORT===========//////
    
}
