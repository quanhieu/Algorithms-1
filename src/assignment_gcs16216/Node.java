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
public class Node<T> {
    T info;
    Node next;
    Node prev;
    
    public Node(){
    }
    
    public Node(T info, Node next, Node prev){
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

}
