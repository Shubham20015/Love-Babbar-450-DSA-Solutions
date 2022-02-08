package internship.heaps;

import java.util.*;

public class MergeKSortedLL {
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
        
        Node []a = new Node[n];
        
        for(int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int j=0; j<x-1; j++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            a[i] = head;
        }
        
        Node res = mergeKList(a,n);
        	
        while(res != null)
        {
            System.out.print(res.data + " ");
            res = res.next;
        }
        
        sc.close();
	}
	
	static class Pair{
        int value;
        Node node;
        Pair(int x,Node i){
            value = x;
            node = i;
        }
    }
	
	static Node mergeKList(Node[]arr,int k)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair o1,Pair o2) -> o1.value - o2.value);
        for(int i=0;i<k;i++){
            if(arr[i] != null){
                pq.add(new Pair(arr[i].data,arr[i]));
            }
        }
        
        Node dummy = new Node(-1);
        Node head = dummy;
        
        while(!pq.isEmpty()){
            Pair temp = pq.poll(); 
            Node curr = temp.node;
            dummy.next = curr;
            dummy = curr;
            
            if(curr.next != null){
                pq.add(new Pair(curr.next.data,curr.next));
            }
        }
        
        dummy.next = null;
        
        return head.next;
    }

}
