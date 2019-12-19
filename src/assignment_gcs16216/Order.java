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
public class Order {
    private String pcode;
    private String ccode;
    private int quantity;
    
    public Order(String pcode, String ccode, int quantity){
        super();           /***/ 
        this.pcode = pcode;
        this.ccode = ccode;
        this.quantity = quantity;
    }
    
    public Order() {
		pcode = null;
		ccode = null;
		quantity = 0;
	}

	public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String toString() {
    	return "\n - pcode: " + pcode + "\n - ccode: " + ccode + "\n - quantity: " + quantity;
    }
    
}
