package internship.linkedList;

import java.util.Scanner;

public class CheckPalindrome {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		if(isPalindrome(list.head)) {
			System.out.println("This linked list is palindrome");
		}else {
			System.out.println("This linked list is not palindrome");
		}
		
		sc.close();

	}
	
	static boolean isPalindrome(Node head) 
    {
        if(head == null)
            return true;
            
        Node curr = head;
        Node mid = findMid(head);
        Node last = reverse(mid);
        
        while(last != null){
            if(last.data != curr.data)
                return false;
            last = last.next;
            curr = curr.next;
        }
        
        return true;
    }
    
    static Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    static Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		
		return head;
	}
}
