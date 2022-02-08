package internship.linkedList;

import java.util.Scanner;

public class ReverseDLLInkGroups {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int groups = sc.nextInt();
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.head = reverse(list.head,groups);
		list.show();
		
		sc.close();
	}
	
	static Node reverse(Node head,int k)
	{
	    if(head == null || head.next == null)
	        return head;
	    
	    head.prev = null;
	    Node temp = null;
	    Node curr = head;
	    Node newNode = null;
	    int count = 0;
	    while(curr != null && count < k){
	        newNode = curr;
	        temp = curr.prev;
	        curr.prev = curr.next;
	        curr.next = temp;
	        curr = curr.prev;
	        count++;
	    }
	    
	    if (curr != null) {
	    	head.next = reverse(curr, k);
            if (head.next != null)
            	head.next.prev = head;
	    }
	    return newNode;
	}
}
