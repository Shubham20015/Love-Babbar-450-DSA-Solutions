package internship.linkedList;

import java.util.Scanner;

import internship.linkedList.Node;

public class StartingPointOfLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int position = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.show();
		makeLoop(list.head,position);
		
		list.show();
		Node temp = detectLoopStarting(list.head);
		
		System.out.println(temp.data);
		
		sc.close();
	}
	
	static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
	
	static Node detectLoopStarting(Node head){
	       Node slow = head;
	       Node fast = head.next;
	       
	       while(fast != null && fast.next != null){
	           slow = slow.next;
	           fast = fast.next.next;
	           if(slow == fast){
	               return slow;
	           }
	       }
	       
	       return null;
	}

}
