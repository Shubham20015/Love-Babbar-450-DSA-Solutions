package internship.linkedList;

public class ReverseDLL {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insert(34);
		list.insert(23);
		list.insert(29);
		list.insert(40);
		list.show();
		list.reverse(); // Implementation in doubly linked list class
		list.show();

	}

}
