package internship.linkedList;

import java.util.Scanner;

public class MiddleElement {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.head = middleNode(list.head);
		list.show();
		
		sc.close();

	}
	
	static Node middleNode(Node head) {
		Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

}
