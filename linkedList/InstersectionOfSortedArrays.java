package internship.linkedList;

import java.util.Scanner;

public class InstersectionOfSortedArrays {

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
		
		list1.head = findIntersection(list1.head,list2.head);
		list1.show();
		
		sc.close();

	}
	
	public static Node findIntersection(Node head1, Node head2)
    {
        Node newNode = new Node(0);
        Node head = newNode;
        
        while(head1 != null && head2 != null){
            if(head1.data == head2.data){
                head.next = new Node(head1.data);
                head = head.next; 
                head1 = head1.next;
                head2 = head2.next;
            }else if(head1.data > head2.data){
                head2 = head2.next;
            }else{
                head1 = head1.next;
            }
        }
        
        return newNode.next;
    }
	
}
