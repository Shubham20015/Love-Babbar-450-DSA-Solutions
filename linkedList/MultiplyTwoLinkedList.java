package internship.linkedList;

import java.util.Scanner;

public class MultiplyTwoLinkedList {

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
		
		long ans = multiplyTwoLists(list1.head,list2.head);
		System.out.println("Multiplication of list1 ans list2: " + ans);
		
		sc.close();

	}
	
	static long multiplyTwoLists(Node l1,Node l2){
        long mod = 1000000007;
        long num1 = 0;
        long num2 = 0;
        while(l1 != null){
            num1 = (l1.data + num1*10)%mod;
            l1 = l1.next;
        } 
        
        while(l2 != null){
            num2 = (l2.data + num2*10)%mod;
            l2 = l2.next;
        } 
        
        return (num1*num2)%mod;
   }
}
