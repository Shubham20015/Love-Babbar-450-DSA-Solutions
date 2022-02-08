package internship.linkedList;

import java.util.Scanner;

public class FindPairsWithSumDLL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = sc.nextInt();
		
		DoublyLinkedList list = new DoublyLinkedList();
		
//		Enter nums in sorted order only
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		findPairs(list.head,sum);
		
		sc.close();
	}
	
	static void findPairs(Node head,int sum) {
		Node curr = head;
		Node last = head;
		
		while(last.next != null) {
			last = last.next;
		}
		
		boolean found = false;
		
		while(curr != last && last.prev != curr) {
			if(curr.data + last.data == sum) {
				System.out.print("("+ curr.data +","+ last.data +") ");
				found = true;
				curr = curr.next;
				last = last.prev;
			}else if(curr.data + last.data < sum) {
				curr = curr.next;
			}else {
				last = last.prev;
			}
		}
		
		if(!found) {
			System.out.print("No pairs for given sum");
		}
		
	}
}
