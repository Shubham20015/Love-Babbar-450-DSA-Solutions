package internship.linkedList;

import java.util.Scanner;

public class MergeSortLL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.head = mergeSort(list.head);
		list.show();
		
		
		sc.close();
	}
	
	static Node mergeSort(Node head)
    {
        if(head.next == null)
            return head;
            
        Node mid = findMid(head);
        Node tail = mid.next;
        mid.next = null;
        
        head = mergeSort(head);
        tail = mergeSort(tail);
        
        return merge(head,tail);
    }
    
    static Node merge(Node head1,Node head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        if(head1.data > head2.data){
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        
        Node res = head1;
        while(head1 != null && head2 != null){
            Node tmp = null;
            while(head1 != null && head1.data <= head2.data){
                tmp = head1;
                head1 = head1.next;
            }
            tmp.next = head2;
            
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        
        return res;
    }
    
//    Slightly modified find mid element program
    static Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

}
