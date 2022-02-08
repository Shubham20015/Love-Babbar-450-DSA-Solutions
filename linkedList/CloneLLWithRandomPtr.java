package internship.linkedList;

import java.util.Scanner;

public class CloneLLWithRandomPtr {
	
	static class ListNode{
		int data;
		ListNode next;
		ListNode arb;
		
		ListNode(int data){
			this.data = data;
			next = arb = null;
		}
	}
	
	ListNode head;
	
//	Main class is not working only copy function works on gfg problem

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		LinkedList ans = new LinkedList();
		
		
		for(int x=0;x<n;x++) {			
				ans.insert(sc.nextInt());
		}
		
//		ans.head = copyList(ans);
		ans.show();
		
		
		sc.close();

	}
	
	 static ListNode copyList(ListNode head) {
	        
	        ListNode curr = head;
	        while(curr != null){
	            ListNode temp = curr.next;
	            curr.next = new ListNode(curr.data);
	            curr.next.next = temp;
	            curr = temp;
	        }
	        
	        curr = head;
	        while(curr != null){
	            curr.next.arb = (curr.arb != null) ? curr.arb.next : null;
	            curr = curr.next.next;
	        }
	        
	        ListNode newHead = new ListNode(0), copyCurr = newHead;
	        ListNode orig = head;
	        while(orig != null){
	            copyCurr.next = orig.next;
	            orig.next = copyCurr.next.next;
	            orig = orig.next;
	            copyCurr = copyCurr.next;
	        }
	        
	        return newHead.next;
	    }
}
