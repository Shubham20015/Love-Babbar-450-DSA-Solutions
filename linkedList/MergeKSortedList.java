package internship.linkedList;

import java.util.Scanner;

public class MergeKSortedList {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		Node arr[] = new Node[k];
		LinkedList ans = new LinkedList();
		
		
		for(int x=0;x<k;x++) {
			int size = sc.nextInt();
			LinkedList list = new LinkedList();
			for(int i=0;i<size;i++) {				
				list.insert(sc.nextInt());
			}
			arr[x] = list.head;
		}
		
		ans.head = mergeKList(arr,k);
		ans.show();
		
		
		sc.close();

	}
	
	static Node mergeKList(Node[]arr,int K)
    {
        Node head = arr[0];
        for(int i=1;i<K;i++){
            head = merge(head,arr[i]);
        }
        return head;
    }
    
    static Node merge(Node head1,Node head2){
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

}
