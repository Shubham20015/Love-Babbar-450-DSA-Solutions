package internship.linkedList;

import java.util.Scanner;

public class SegregateEvenOdd {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.head = divide(n,list.head);
		list.show();
		
		sc.close();
	}
	
	static Node divide(int N, Node head){
        Node evenHead = new Node(-1);
        Node oddHead = new Node (-1);
        Node even = evenHead,odd = oddHead;
        Node curr = head;
        
        while(curr != null){
            if(curr.data%2 == 0){
                even.next = curr;
                even = even.next;
            }else{
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }
        
        even.next = oddHead.next;
        odd.next = null;
        return evenHead.next;
    }

}
