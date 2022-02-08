package internship.linkedList;

import internship.linkedList.Node;

public class ShiftLastToFirst {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.insert(34);
		list.insert(23);
		list.insert(29);
		list.insert(40);
		list.insert(9);
		list.show();
		
		list.head = shift(list.head);
		list.show();
	}
	
	static Node shift(Node node) {
		Node last = node;
		Node secondLast = null;
		while(last.next != null) {
			secondLast = last;
			last = last.next;
		}
		
		secondLast.next = null;
		last.next = node;
		node = last;
		
		return node;
	}

}
