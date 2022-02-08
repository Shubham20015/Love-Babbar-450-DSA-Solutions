package internship.linkedList;

import java.util.Scanner;

public class RotateDLL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int rotation = sc.nextInt();
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		if(rotation == 0 || rotation  >= n) {
			System.out.print("No rotation possible");
			System.exit(0);
		}
		
		Node head = list.head;
		Node last = head;
		
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = head;
		head.prev = last;
		
		for(int i=0;i<rotation;i++) {
			head = head.next;
		}
		
		head.prev.next = null;
		head.prev = null;
		
		list.head = head;
		
		list.show();
		
		sc.close();
	}

}
