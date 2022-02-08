package internship.linkedList;

import internship.linkedList.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.insert(34);
		list.insert(23);
		list.insert(29);
		list.insert(40);
		list.show();
		list.reverse(); // normal iteration call
		list.show();
		list.head = reverse(list.head); // recursive call
		list.show();
		
		
	}
	
	static Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node rest = reverse(head.next);
		head.next.next = head;
		
		head.next = null;
		
		return rest;
	}

}
