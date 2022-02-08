package internship.linkedList;

import java.util.Scanner;

public class CircularChecker {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		circular(list.head);
		list.show();
		
		if(isCircular(list.head)) {
			System.out.println("Yes, it is circular.");
		}else {
			System.out.println("No, it is not circular.");
		}
		
		sc.close();

	}
	
	static void circular(Node head)
	{
		    Node last = head;
			while (last.next != null)
				last = last.next;
			last.next = head;
	}
	
	static boolean isCircular(Node head)
    {
	    Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        
        return false;
    }

}
