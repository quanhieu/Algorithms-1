package assignment_gcs16216;



public class MyCustomerStack {
	private MyList<Customer> customers;

	public MyCustomerStack() {
		customers = new MyList<Customer>();
	}

	// kiem tra xem stack co rong hay khong
	public boolean isEmpty() {
		return customers.isEmpty();
	}

	// them 1 doi tuong vao dau stack <=> theo co che LIFO
	public void push(Customer x) {
		customers.addLast(x);
	}

	// lay phan tu dau stack va tra ve gia tri cua doi tuong stack dong thoi phai
	// huy no di
	public Customer pop() {
		return customers.removeLast();
	}

	// xem thong tin stack dau danh sach va khong huy no
	public Customer top() {
		return customers.tail.info;
	}
}
