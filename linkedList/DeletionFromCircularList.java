package internship.linkedList;

import java.util.Scanner;

public class DeletionFromCircularList {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int key = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		circular(list.head);
		list.head = delete(list.head,key);
		list.printList(list.head);
		
		sc.close();
	}
	
	static Node delete(Node head, int key) {
		if(head == null)
			return head;
		
		Node curr = head;
		Node prev = head;
		
		while(curr.data != key) {
			
			if(curr.next == head) {
				System.out.println("No key: "+ key +"present in linked list");
				break;
			}
			
			prev = curr;
			curr = curr.next;
		}
		
		if(curr == head && curr.next == head) {
			head = null;
			return head;
		}
		
		if(curr == head) {
			prev = head;
			while(prev.next != head) {
				prev = prev.next;
			}
			head = curr.next;
			prev.next = head;
		}
		
		else if(curr.next == head) {
			prev.next = head;
		}else {
			prev.next = curr.next;
		}
		return head;
	}
	
	static void circular(Node head)
	{
		Node last = head;
		while (last.next != null)
			last = last.next;
		last.next = head;
	}
}
