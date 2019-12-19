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
//public class Product{
public class Product implements Comparable<Product>{

    private String pcode;
    private String pname;
    private int quantity;
    private int saled;
    private double price;
    
    public Product(String pcode, String pname, int quantity, int saled, double price){
        this.pcode = pcode;
        this.pname = pname;
        this.quantity = quantity;
     //   setSaled(saled);
        this.saled = saled;
        this.price = price;
    }

    public Product(){
		
    }
    
     public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
     public void setSaled(int saled) {
        if(saled <= quantity)
        this.saled = saled;
    }
     
    public int getSaled() {
        return saled;
    }
//
//    public void setSaled(int saled) {
//        if(saled <= quantity)
//        this.saled = saled;
//    }

//   public String toString(){
//       return   "pCode: " +pcode + "\nPname: " +pname;
//   }
    
//    @Override
//	public String toString() {
//		return "Product [pcode=" + pcode + "\npname=" + pname + "\nquantity=" + quantity + "\nsaled=" + saled
//				+ "\nprice=" + price + "]";
//	}
    
    // https://stackoverflow.com/questions/28855350/java-mergesort-for-objects-of-arraylist
    @Override
	public String toString() {
		return "pcode: " + pcode + "\npname: " + pname + "\nquantity: " + quantity + "\nsaled: " + saled
				+ "\nprice: " + price;
	}
    
    @Override
    public int compareTo(Product product) {
        return this.getPname().compareTo(product.getPname());
    }

    public boolean isLessThan(Product product) {
        boolean isLess = false;
         if(this.getPname().compareTo(product.getPname()) < 0) {
             isLess = true;
         }
         return isLess;
    }
    
   
    public int compareToPcode(Product product) {
        return this.getPcode().compareTo(product.getPcode());
    }
    
}
