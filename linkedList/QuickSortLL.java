package internship.linkedList;

import java.util.Scanner;

public class QuickSortLL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		quickSort(list.head);
		list.show();
		
		sc.close();

	}
	
	public static void quickSort(Node node)
    {
        Node tail = node;
        while(tail.next != null){
            tail = tail.next;
        }
        quickSort_(node,tail);
    }
    
    static void quickSort_(Node head,Node tail){
        if(head == tail || tail == null || head == null)
            return ;
        Node pivot = partition(head,tail);
        quickSort_(head,pivot);
        quickSort_(pivot.next,tail);
    }
    
    static Node partition(Node head,Node tail){
        Node curr = head.next;
        Node prev = head;
        Node pivot = head;
        
        while(curr != null){
            if(curr.data < pivot.data){
                swap(prev.next,curr);
                prev = prev.next;
            }
            curr = curr.next;
        }
        swap(pivot,prev);
        return prev;
    }
    
    static void swap(Node a,Node b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
}
