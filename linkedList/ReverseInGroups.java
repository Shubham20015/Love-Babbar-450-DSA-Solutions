package internship.linkedList;

import java.util.*;

import internship.linkedList.Node;

public class ReverseInGroups {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			list.insert(x);
		}
		
		list.show();
		list.head = reverseInK(list.head,k);
		list.show();
		
		sc.close();

	}
	
	public static Node reverseInK(Node node, int k)
    {
        int count = 0;
        Node prev = null;
		Node curr = node;
		Node next = null;
		
		while(curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(curr != null)
		    node.next = reverseInK(curr,k);
		
		node = prev;
		
		return node;
    }

}
