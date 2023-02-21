package CSD_ASM2;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MyList<T> {
	
	Node<T> head;
	Node<T> tail;

	public MyList() {
		head = tail = null;
	}

	public MyList(Node<T> head, Node<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {
		head = tail = null;
	}

	// độ dài linked list
	public int length() {
		int count = 0;
		Node<T> t = head;
		while (t != null) {
			count++;
			t = t.next;
		}
		return count;
	}

	// thêm phần tử vào đầu linked list
	public void addToHead(T item) {
		Node<T> newNode = new Node<>(item);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	// thêm phần tử vào cuối linked list
	public void addToTail(T item) {
		Node<T> newNode = new Node<>(item);
		if (isEmpty()) {
			newNode.next = head;
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	// xóa phần tử cuối cùng của linked list
	public void deleteTail() {
		Node<T> prev = head;
		while (prev.next != null) {
			prev = prev.next;
		}
		prev.next = null;
		tail = prev;
	}

	// xóa phần tử trong linked list
	public void deleteElement(T item) {
		Node<T> cur = head;
		Node<T> pre = head;
		if (isEmpty()) {
			System.out.println("List is empty!");
		} else if (head.data.equals(item)) {
			head = head.next;
		} else {
			while (cur.next != null) {
				if (cur.data.equals(item)) {
					break;
				}
				pre = cur;
				cur = cur.next;
			}
			pre.next = cur.next;
			if (pre.next == null) {
				tail = pre;
			}
		}
	}

	// hiện thị thông tin linked list
	public void printLinkedList() {
		System.out.println("ID |  Title   | Quantity | price");
		System.out.println("--------------------------------");
		if (isEmpty()) {
			System.out.println("List is empty!");
		} else {
			Node<T> t = head;
			while (t != null) {
				System.out.println(t.data);
				t = t.next;
			}
		}
	}
	// nhập dữ liệu vào file
	public void writeToFile(String fileName, MyList<Product> list) {
		try {
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Node<Product> t = list.head;
			while (t != null) {
				bw.write(t.data.getBcode());
				bw.write(" | ");
				bw.write(t.data.getTitle());
				bw.write(" | ");
				bw.write(Integer.toString(t.data.getQuantity()));
				bw.write(" | ");
				bw.write(Double.toString(t.data.getPrice()));
				bw.newLine();
				t = t.next;
			}
			
			bw.close();
			fw.close();
		} catch (Exception e) {

		}
	}

	// tìm kiếm
	public Node<Product> search(String item, MyList<Product> list) {
		Node<Product> n = list.head;
		while (n != null) {
			if (n.data.getBcode().equals(item)) {
				return n;
			}
			n = n.next;
		}
		return null;
	}
}
