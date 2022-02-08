package internship.linkedList;

import java.util.Scanner;

public class FlatteningLinkedList {
	
	static class ListNode{
		int data;
		ListNode next;
		ListNode bottom;
		
		ListNode(int d)
		{
			data = d;
			next = null;
			bottom = null;
		}
	}
	
	static class Flatttening_A_LinkedList{
		
		ListNode head;
		
		public void show() {
			ListNode curr = head;
			while(curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		
		while(t-->0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			ListNode temp = null;
			ListNode tempB = null;
			ListNode pre = null;
			ListNode preB = null;	
			
			int flag=1;
			int flag1=1;
			
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new ListNode(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new ListNode(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			
			list.head = flatten(list.head);
			list.show();
		}
		
		sc.close();
	}	
	
	static ListNode flatten(ListNode root)
    {
	   if(root == null || root.next == null)
	    return root;
	   
	   root.next = flatten(root.next);
	   
	   root = mergeTwoList(root,root.next);
	   
	   return root;
    }
    
    static ListNode mergeTwoList(ListNode head1,ListNode head2){
    	ListNode temp = new ListNode(0);
    	ListNode res = temp;
        
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.bottom = head1;
                temp = temp.bottom;
                head1 = head1.bottom;
            }else{
                temp.bottom = head2;
                temp = temp.bottom;
                head2 = head2.bottom;
            }
        }
        
        if(head1 != null){
            temp.bottom = head1;
        }else{
            temp.bottom = head2;
        }
        
        return res.bottom;
    }

}
