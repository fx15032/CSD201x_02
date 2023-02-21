package CSD_ASM2;

public class MyStack<T>{

	Node<T> head;
	int size = 0;

	public MyStack() {
		head = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {
		head = null;
	}

	// thêm phần tử vào stack
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.next = head;
		head = newNode;
		size++;
	}

	// in ra phần tử trong stack
	public void display() {
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
}
