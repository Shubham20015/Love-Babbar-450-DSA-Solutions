package internship;

import java.util.*;

public class Kth_MaxElement {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		int k = sc.nextInt();
		
		PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i=0;i<n;i++) {
			pq.offer(arr[i]);
			if(pq.size() > k)
				pq.poll();
		}
		
		System.out.print(pq.peek());
		sc.close();	
	}

}
