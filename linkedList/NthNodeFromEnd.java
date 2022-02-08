package internship.linkedList;

import java.util.Scanner;

public class NthNodeFromEnd {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		int ans = getNthFromLast(list.head,x);
		System.out.println("Nth Node from end: " + ans);
		
		sc.close();

	}
	
	static int getNthFromLast(Node head, int n)
    {
    	Node curr = head;
    	int count = 0;
    	while(curr != null){
    	    count++;
    	    curr = curr.next;
    	}
    	
    	int x = count - n;
    	
    	if(x < 0)
    	    return -1;
    	
    	while(x-->0){
    	    head = head.next;
    	}    
    	
    	return head.data;
    }
}
