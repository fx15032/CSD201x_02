package CSD_ASM2;

import java.util.Scanner;

public class Main {

	public static void showManu() {
		System.out.println("----------------------------------");
		System.out.println("Choose one of this options:");
		System.out.println("Product list:");
		System.out.println("1. Load data from file and display");
		System.out.println("2. Input & add to the end");
		System.out.println("3. Display data");
		System.out.println("4. Save product list to file");
		System.out.println("5. Search by ID");
		System.out.println("6. Delete by ID");
		System.out.println("7. Sort by ID");
		System.out.println("8. Convert by Binary");
		System.out.println("9. Load to stack and display");
		System.out.println("10. Load to queue and display");
		System.out.println("0. Exit");
		System.out.print("Choice: ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OperationToProduct otp = new OperationToProduct();
		MyList<Product> list = new MyList<>(); 
		MyStack<Product> stack = new MyStack<>();
		MyQueue<Product> queue = new MyQueue<>();
		int choice; 
		do {
			showManu();
			choice = Integer.parseInt(sc.nextLine());
			System.out.println("----------------------------------");
			switch (choice) {
			case 1:
				otp.getAllItemsFromFile("data.txt", list);
				break;
			case 2:
				System.out.println("Add new product");
				System.out.println("How many product to import?:");
				int n = Integer.parseInt(sc.nextLine());
				for(int i = 0;i<n;i++) {
					System.out.println("Enter product");
					Product newProduct = new Product();
					otp.inputProduct(newProduct, sc);
					otp.addLast(newProduct, list);
				}
				break;
			case 3:
				if (list.isEmpty()) {
					System.out.println("List is empty!");
				} else {
					list.printLinkedList();
				}
				break;
			case 4:
				if(!list.isEmpty()) {
					list.writeToFile("data.txt", list);
					System.out.println("Successfully!");
				} else {
					System.out.println("List is empty");
				}
				break;
			case 5:
				if (list.isEmpty()) {
					System.out.println("List is empty!");
				} else {
					System.out.println("Input the ID to search: ");
					String id = sc.nextLine();
					if(list.search(id, list) != null) {
						System.out.println("Result: " + list.search(id, list).data);
					} else {
						System.out.println(-1);
					}
				}
				break;
			case 6:
				otp.deleteElement(list, sc);
				break;
			case 7:
				otp.sortByCode(list);
				System.out.println("Successfully!");
				break;
			case 8:
				System.out.print("Quantity="+ list.head.data.getQuantity() + "=>(");
				otp.convertToBinary(list.head.data.getQuantity());
				System.out.println(")");
				break;
			case 9:
				otp.getAllItemsFromFile("data.txt", stack);
				break;
			case 10:
				otp.getAllItemsFromFile("data.txt", queue);
				break;
			case 0:
				System.out.println("Thanks you!");
				break;

			default:
				System.out.println("Please select the program again!");
				break;
			}
		} while (choice != 0);

	}

}
