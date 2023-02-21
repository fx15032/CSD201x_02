package CSD_ASM2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class OperationToProduct {
	
	// đọc dữ liệu từ file và lưu vào danh sách liên kết
		public void getAllItemsFromFile(String fileName, MyList<Product> list) {
			list.clear();
			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);

				String line = br.readLine();
				while (line != null) {
					line = line.replace("|", ",");
					line = line.replace(" ", "");
					String[] x = line.split(",");
					Product product = new Product();
					product.setBcode(x[0]);
					product.setTitle(x[1]);
					product.setQuantity(Integer.parseInt(x[2]));
					product.setPrice(Double.parseDouble(x[3]));

					list.addToTail(product);
					line = br.readLine();

				}
				list.printLinkedList();

				System.out.println("\nSuccessfully!");
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// nhập thông tin product
		public void inputProduct(Product newProduct, Scanner sc) {
			System.out.print("Input new ID: ");
			newProduct.setBcode(sc.nextLine());
			System.out.print("Input Product's Name: ");
			newProduct.setTitle(sc.nextLine());
			System.out.print("Input Product's quantity: ");
			newProduct.setQuantity(Integer.parseInt(sc.nextLine()));
			System.out.print("Input Product's price: ");
			newProduct.setPrice(Double.parseDouble(sc.nextLine()));
		}
		// thêm phần tử vào đuôi linked list
		public void addLast(Product newProduct, MyList<Product> list) {
			list.addToTail(newProduct);
		}
		// xóa phần tử trong linked list
		public void deleteElement(MyList<Product> list, Scanner sc) {
			System.out.print("Input the bcode to delete: ");
			String key = sc.nextLine();
			Node<Product> n = list.head;
			while (n != null) {
				if (n.data.getBcode().equalsIgnoreCase(key)) {
					list.deleteElement(n.data);
					System.out.println("Deleted!");
					return;
				}
				n = n.next;
			}
			System.out.println("-1");
		}

		// sắp xếp linked list	
		public void sortByCode(MyList<Product> list) {
			if (list.head == list.tail) {
				return;
			}

			MyList<Product> l1 = new MyList<>();
			MyList<Product> l2 = new MyList<>();

			Node<Product> tag;
			Node<Product> p;
			tag = list.head;
			list.head = list.head.next; // cập nhật lại list.head
			tag.next = null; // cô lập tag

			while (list.head != null) {
				p = list.head;
				list.head = list.head.next;
				p.next = null;
				if (p.data.getBcode().compareToIgnoreCase(tag.data.getBcode()) <= 0) {
					l1.addToHead(p.data);
				} else {
					l2.addToHead(p.data);
				}
			}
			// gọi đệ quy sắp xếp l1,l2
			sortByCode(l1);
			sortByCode(l2);

			if (l1.head != null) { // l1 không rỗng
				list.head = l1.head; // lấy head cua l1 gắn cho head của list
				l1.tail.next = tag;
			} else {
				list.head = tag; // l1 rỗng
			}

			if (l2.head != null) {
				tag.next = l2.head;
				list.tail = l2.tail;
			} else {
				list.tail = tag;
			}
		}

		// chuyển đổi cơ số mười sang nhị phân
		public void convertToBinary(int x) {
			int y;
			if (x <= 1) {
				System.out.print(x);
				return;
			}
			y = x % 2;
			x /= 2;
			convertToBinary(x);
			System.out.print(y);
		}
		// hiển thị thông tin ngược vào stack
		public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
			stack.clear();
			stack.size = 0;
			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);

				String line = br.readLine();
				while (line != null) {
					line = line.replace("|", ",");
					line = line.replace(" ", "");
					String[] x = line.split(",");
					Product product = new Product();
					product.setBcode(x[0]);
					product.setTitle(x[1]);
					product.setQuantity(Integer.parseInt(x[2]));
					product.setPrice(Double.parseDouble(x[3]));

					stack.push(product);
					line = br.readLine();
				}

				System.out.println("ID |  Title   | Quantity | price");
				System.out.println("--------------------------------");
				stack.display();

				System.out.println("\nSuccessfully!");
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// hiển thị thông tin theo thứ tự của queue
		public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
			queue.clear();
			queue.size = 0;
			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);

				String line = br.readLine();
				while (line != null) {
					line = line.replace("|", ",");
					line = line.replace(" ", "");
					String[] x = line.split(",");
					Product product = new Product();
					product.setBcode(x[0]);
					product.setTitle(x[1]);
					product.setQuantity(Integer.parseInt(x[2]));
					product.setPrice(Double.parseDouble(x[3]));

					queue.addToHead(product);
					line = br.readLine();
				}

				System.out.println("ID |  Title   | Quantity | price");
				System.out.println("--------------------------------");
				Product[] p = new Product[queue.size];
				Node<Product> t = queue.head;
				int i = 0;
				while (t != null) {
					p[i] = t.data;
					i++;
					t = t.next;
				}
				for (int j = queue.size - 1; j >= 0; j--) {
					System.out.println(p[j]);
				}

				System.out.println("\nSuccessfully!");
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
