package internship.linkedList;

import java.util.Scanner;

public class AddTwoNumbers {

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
		
		list1.head = addTwoLists(list1.head,list2.head);
		list1.show();
		
		sc.close();

	}
	
	static Node addTwoLists(Node first, Node second){
        first = reverse(first);
        second = reverse(second);
        if(length(first) >= length(second)){
            return add(first,second);
        }
        return add(second,first);
    }
    
    static Node reverse(Node node){
        Node prev = null;
        Node curr = node;
        Node next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        node = prev;
        
        return node;
    }
    
    static Node add(Node first, Node second){
        
        int sum = 0,carry = 0;
        Node temp = first;
        
        while(first != null){
            sum = carry + (first != null? first.data:0) + (second != null? second.data:0);
            carry = sum >=10 ? 1:0;
            sum = sum%10;
            first.data = sum;
            first = first.next;
            if(second != null) second = second.next;
        }
        
        if(carry > 0){
            Node res = new Node(carry);
            temp = reverse(temp);
            res.next = temp;
            return res;
        }
        
        return reverse(temp);
    }
    
    static int length(Node node){
        int count = 0;
        Node curr = node;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        
        return count;
    }
}
