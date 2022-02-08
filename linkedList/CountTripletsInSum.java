package internship.linkedList;

import java.util.Scanner;

public class CountTripletsInSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = sc.nextInt();
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		System.out.println("No. of triplets present in DLL" + countTriplets(list.head,sum));
		
		sc.close();
	}
	
	static int findPairs(Node curr,Node last,int sum) {
		int count = 0;
		
		while(curr != null && last != null && curr != last && last.next != curr) {
			if(curr.data + last.data == sum) {
				count++;
				curr = curr.next;
				last = last.prev;
			}else if(curr.data + last.data < sum) {
				curr = curr.next;
			}else {
				last = last.prev;
			}
		}
		
		return count;
	}
	
	static int countTriplets(Node head,int sum) {
		int count = 0;
		
		Node curr = head;
		Node last = head;
		Node first = null;
		
		while(last.next != null) {
			last = last.next;
		}
		
		while(curr != null) {
			first = curr.next;
			count += findPairs(first,last,sum - curr.data);
			curr = first;
		}
		
		return count;
	}
}
