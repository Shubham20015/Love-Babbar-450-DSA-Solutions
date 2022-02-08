package internship.linkedList;

import java.util.Scanner;

public class IntersectionPointInLinkedListY {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list1.insert(sc.nextInt());
		}
		
		for(int i=0;i<m;i++) {
			list2.insert(sc.nextInt());
		}
		
		intersect(list1.head,list2.head,3);
		
		int ans = intersectPoint(list1.head,list2.head);
		
		if(ans == -1) {
			System.out.println("No intersection point in these linked list.");
		}else {
			System.out.println("Intersection point present at " + ans);
		}
		
		sc.close();

	}
	
	static void intersect(Node head1,Node head2,int pos) {
		
		Node temp1 = head1;
		while(pos-->0) {
			temp1 = temp1.next;
		}
		
		Node temp2 = head2;
		while(temp2.next != null) {
			temp2 = temp2.next;
		}
		
		temp2.next = temp1;
	}
	
	static int intersectPoint(Node head1, Node head2)
	{
         int l1 = length(head1);
         int l2 = length(head2);
         Node ptr1 = null;
         Node ptr2 = null;
         int diff = 0;
         
         if(l1>l2){
             diff = l1 - l2;
             ptr1 = head1;
             ptr2 = head2;
         }else{
             diff = l2 - l1;
             ptr1 = head2;
             ptr2 = head1;
         }
         
         while(diff-->0){
             ptr1 = ptr1.next;
             
             if(ptr1 == null)
                return -1;
         }
         
         while(ptr1 != null && ptr2 != null){
             if(ptr1 == ptr2)
                return ptr1.data;
             
             ptr1 = ptr1.next;
             ptr2 = ptr2.next;
         }
         
         return -1;
	}
	
	static int length(Node head){
	    int count = 0;
	    
	    while(head != null){
	        count++;
	        head = head.next;
	    }
	    
	    return count;
	}

}
