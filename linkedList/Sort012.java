package internship.linkedList;

import java.util.Scanner;

public class Sort012 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<n;i++) {
			list.insert(sc.nextInt());
		}
		
		list.head = segregate(list.head);
		list.show();
		
		sc.close();

	}
	
	static Node segregate(Node head)
    {
        Node curr = head;
        int count0 = 0,count1 = 0;
        while(curr != null){
            int x = curr.data;
            if(x == 0)
                count0++;
            else if(x == 1)
                count1++;
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            if(count0-->0)
                curr.data = 0;
            else if(count1-->0)
                curr.data = 1;
            else
                curr.data = 2;
            curr = curr.next;
        }
        
        return head;
    }

}
