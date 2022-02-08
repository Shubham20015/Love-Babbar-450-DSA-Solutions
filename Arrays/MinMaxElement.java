package internship;

import java.util.*;

public class MinMaxElement {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of Array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			pq.offer(arr[i]);
			if(pq.size() > k) {
				System.out.println(pq.poll());
				break;
			}
		}
		
		System.out.println("Kth Smallest element in array: " + pq.peek());
		
//		System.out.println("Minimum element in array: " + min);
//		System.out.println("Maximum element in array: " + max);
		
		sc.close();
	}

}
