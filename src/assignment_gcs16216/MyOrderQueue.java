package assignment_gcs16216;

public class MyOrderQueue {
	private MyList<Order> orders;

	public MyOrderQueue() {
		orders = new MyList<Order>();
	}

	public void enqueue(Order order) {
		orders.addLast(order);
	}

	public Order dequeue() {
		return orders.removeFirst();
	}

	public Order top() {
		if (orders.isEmpty())
			return null;
		return orders.head.info;
	}

	public void sortPcode() {
		Node<Order> node = orders.head;

		Node<Order> head = null, tail = null;
		while (node != null) {
			Node<Order> min = node;
			Node<Order> node2 = node.next;
			while (node2 != null) {
				if (node2.info.getPcode().compareTo(min.info.getPcode()) < 0) {
					min = node2;
				}
				node2 = node2.next;
			}

			orders.remove1(min);

			if (head == null) {
				head = tail = min;
				min.next = min.prev = null;
			} else {
				tail.next = min;
				tail = min;
				min.prev = tail;
				min.next = null;
			}

			node = orders.head;
		}

		orders.head = head;
		orders.tail = tail;
	}

	public void sortccode() {
		Node<Order> stack = orders.head;
		Node<Order> head = null, tail = null;
		while (stack != null) {
			Node<Order> min = stack;
			Node<Order> node2 = stack.next;
			while (node2 != null) {
				if (node2.info.getCcode().compareTo(min.info.getCcode()) < 0) {
					min = node2;
				}
				node2 = node2.next;
			}

			orders.remove1(min);

			if (head == null) {
				head = tail = min;
				min.next = min.prev = null;
			} else {
				tail.next = min;
				tail = min;
				min.prev = tail;
				min.next = null;
			}

			stack = orders.head;
		}

		orders.head = head;
		orders.tail = tail;
	}

	public void sortpcode() {
		Node<Order> node = orders.head;
		MyList<Order> listNew = new MyList<Order>();

		while (node != null) {
			Node<Order> min = node;
			Node<Order> node2 = node.next;
			while (node2 != null) {
				if (node2.info.getPcode().compareTo(min.info.getPcode()) < 0) {
					min = node2;
				}
				node2 = node2.next;
			}

			orders.remove1(min);
			listNew.addLast(min.info);

			node = orders.head;
		}

		orders = listNew;
	}

	public void mergeSort() {
		mergeSort(orders);
	}

	//https://vietjack.com/cau-truc-du-lieu-va-giai-thuat/giai-thuat-sap-xep-tron.jsp
	//https://www.geeksforgeeks.org/merge-sort-for-doubly-linked-list/
	private void mergeSort(MyList<Order> list) {
		if (list.isEmpty() || list.head.next == null)
			return;
		MyList<Order> list1, list2;
		list1 = new MyList<Order>();
		list2 = new MyList<Order>();
		while (!list.isEmpty()) {
			list1.addLast(list.removeFirst());
			if (!list.isEmpty())
				list2.addLast(list.removeFirst());
		}
		mergeSort(list1);
		mergeSort(list2);

		while (!list1.isEmpty() && !list2.isEmpty()) {
			if (list1.head.info.getPcode().compareTo(list2.head.info.getPcode()) < 0) {
				list.addLast(list1.removeFirst());
			} else
				list.addLast(list2.removeFirst());

			if (list1.isEmpty()) {
				list.tail.next = list2.head;
				list2.head.prev = list.tail;
				list.tail = list2.tail;
			}
//			else {
////				list.head.next = list1.tail;
////				list1.tail.prev = list.head;
////				list.head = list1.head;
//			}
			if (list2.isEmpty()) {
				list.tail.next = list1.head;
				list1.head.prev = list.tail;
				list.tail = list1.tail;
			}
		}
	
	}
	
	public void mergeSortccode() {
		mergeSortccode(orders);
	}
	private void mergeSortccode(MyList<Order> list) {
		if (list.isEmpty() || list.head.next == null)
			return;
		MyList<Order> list3, list4;
		list3 = new MyList<Order>();
		list4 = new MyList<Order>();
		while (!list.isEmpty()) {
			list3.addLast(list.removeFirst());
			if (!list.isEmpty())
				list4.addLast(list.removeFirst());
		}
		mergeSortccode(list3);
		mergeSortccode(list4);

		while (!list3.isEmpty() && !list4.isEmpty()) {
			if (list3.head.info.getCcode().compareTo(list4.head.info.getCcode()) < 0) {
				list.addLast(list3.removeFirst());
			} else
				list.addLast(list4.removeFirst());

			if (list3.isEmpty()) {
				list.tail.next = list4.head;
				list4.head.prev = list.tail;
				list.tail = list4.tail;
			}
			if (list4.isEmpty()) {
				list.tail.next = list3.head;
				list3.head.prev = list.tail;
				list.tail = list3.tail;
			}
		}
	
	}
	
}
