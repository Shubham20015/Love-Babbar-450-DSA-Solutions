package internship.linkedList;

import java.util.Scanner;

import internship.linkedList.Node;

public class Add1ToGivenNo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.head = addOne(list.head);
		list.show();
		
		sc.close();

	}
	
	public static Node addOne(Node head) 
    { 
        head = reverse(head);
        head = addUtilOne(head);
        return reverse(head);
    }
    
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        
        return head;
    }
    
    static Node addUtilOne(Node head){
        Node res = head;
        Node prev = null;
        int sum = 0,carry = 1;
        
        while(res != null){
            sum = carry + (res != null? res.data:0);
            carry = sum >=10 ? 1:0;
            sum = sum%10;
            res.data = sum;
            prev = res;
            res = res.next;
        }
        
        if(carry > 0){
            prev.next = new Node(carry);
        }
        
        return head;
    }

}
