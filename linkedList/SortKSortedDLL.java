package internship.linkedList;

import java.util.*;

public class SortKSortedDLL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.head = kSorted(list.head,k);
		list.show();
		
		sc.close();
	}
	
	static Node kSorted(Node head,int k) {
		
		if(head == null) {
			return head;
		}
		
		PriorityQueue<Node> pq = new  PriorityQueue<>((Node head1,Node head2) -> head1.data - head2.data);
		
		for(int i=0;head != null && i<=k;i++) {
			pq.offer(head);
			head = head.next;
		}
		
		Node node = null;
		Node curr = null;
		while(!pq.isEmpty()) {
			
			if(node == null) {
				node = pq.peek();
				node.prev = null;
				curr = node;
			}else {
				Node temp = pq.peek();
				curr.next = temp;
				temp.prev = curr;
				curr = temp;
			}
			
			pq.poll();
			
			if(head != null) {
				pq.offer(head);
				head = head.next;
			}
		}
		
		curr.next = null;
		return node;
	}

}
