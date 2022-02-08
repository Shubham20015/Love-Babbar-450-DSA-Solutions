package internship.linkedList;

import java.util.Scanner;

public class DeleteNodesGreaterRight {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.head = compute(list.head);
		list.show();
		
		sc.close();
	}
	
	static Node compute(Node head)
    {
	       if(head == null || head.next == null){
	           return head;
	       }    
	       head = reverse(head);
	       Node curr = head.next;
	       Node prev = head;
	       while(curr != null){
	           if(prev.data > curr.data){
	               prev.next = curr.next;
	           }else{
	               prev = curr;
	           }
	           curr = curr.next;
	       }
	       
	       return reverse(head);
	 }
	
	static Node reverse(Node head)
    {
        Node cur=head;
        Node prev=null;
        while(cur!=null)
        {
            Node temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
