package internship.linkedList;

import java.util.Scanner;

import internship.linkedList.Node;

public class RemoveDuplicatesInSorted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.show();
		list.head = removeDuplicates(list.head);
		list.show();
		
		sc.close();

	}
	
	static Node removeDuplicates(Node head)
    {
	    Node dp = head;
	    while(dp.next != null){
	        if(dp.data == dp.next.data){
	            dp.next = dp.next.next;
	        }else{
	            dp = dp.next;
	        }
	    }
	    
	    return head;
    }

}
