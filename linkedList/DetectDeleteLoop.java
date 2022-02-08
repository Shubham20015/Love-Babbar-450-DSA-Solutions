package internship.linkedList;

import java.util.Scanner;

import internship.linkedList.Node;

public class DetectDeleteLoop {

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
		removeLoop(list.head);
		
		if(detectLoop(list.head))
            System.out.println("0");
        else
            System.out.println("1");
		
		sc.close();

	}
	
	
	
	public static void makeLoop(Node head, int x){
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
	
	static boolean detectLoop(Node head){
	       Node slow = head;
	       Node fast = head.next;
	       
	       while(fast != null && fast.next != null){
	           slow = slow.next;
	           fast = fast.next.next;
	           if(slow == fast){
	               return true;
	           }
	       }
	       
	       return false;
	}
	
	static void removeLoop(Node head){
        
        if(head == null || head.next == null)
            return;
            
        Node slow = head;
        Node fast = head;
        Node prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }    
        
        if(slow != fast)
            return;
        
        fast = head;
        
        while(slow != fast){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        prev.next = null;
    }

}
