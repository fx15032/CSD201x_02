package CSD_ASM2;

public class MyQueue<T> {

	Node<T> head;
	Node<T> tail;
	int size;

	public MyQueue() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {
		head = tail = null;
	}

	// thêm vào queue
	public void addToHead(T item) {
		Node<T> newNode = new Node<>(item);
		if (isEmpty()) {
			head = tail = newNode;
			size++;
		} else {
			newNode.next = head;
			head = newNode;
			size++;
		}
	}
}
