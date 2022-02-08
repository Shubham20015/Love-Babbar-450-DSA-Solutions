package internship.linkedList;

import java.util.*;

import internship.linkedList.Node;

public class RemoveDuplicatesInUnsorted {

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
         HashSet<Integer> set = new HashSet<>();
         
         Node curr = head;
         Node prev = null;
         
         while(curr != null){
             if(set.contains(curr.data)){
                 prev.next = curr.next;
             }else{
                set.add(curr.data);
                prev = curr;
             }
             curr = curr.next;
         }
         
         return head;    
    }
}
