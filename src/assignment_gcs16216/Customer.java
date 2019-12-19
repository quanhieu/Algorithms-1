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
public class Customer {
	private String ccode;
	private String cus_name;
	private String phone;

	public Customer(String ccode, String cus_name, String phone) {
		this.ccode = ccode;
		this.cus_name = cus_name;
		// this.phone = phone;
		setPhone(phone);
	}
	public Customer() {
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getC_name() {
		return cus_name;
	}
	public void setC_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		if (checkPhone(phone))
			this.phone = phone;
	}
	private boolean checkPhone(String phone) {
		return true;
	}
	public String toString() {
		String ret = "ccode: " + ccode + "\ncname: " + cus_name + "\nphone: " + phone;
		return ret;
	}

}
