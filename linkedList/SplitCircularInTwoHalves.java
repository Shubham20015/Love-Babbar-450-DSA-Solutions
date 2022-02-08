package internship.linkedList;

import java.util.Scanner;

// In this function, only splitList function work and main is not working due to wrong implementation 

public class SplitCircularInTwoHalves {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		splitList(list);
		list.show();
		
		
		list.printList(list.head1);
		list.printList(list.head2);
		
		sc.close();
	}
	
	static void splitList(LinkedList list)
    {
         Node head = list.head;
         Node mid = midElement(head);
         Node last = mid.next;
         
         while(last.next != head){
             last = last.next;
         }
         
         list.head2 = mid.next;
         list.head1 = head;
         last.next = mid.next;
         mid.next = head;
    }
    
    static Node midElement(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast.next != head && fast.next.next != head){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
}
