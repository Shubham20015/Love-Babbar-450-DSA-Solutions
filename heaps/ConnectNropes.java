package internship.heaps;

import java.util.*;

public class ConnectNropes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		System.out.println(minCost(arr,n));
		
		sc.close();
	}
	
	static long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        
        long sum = 0;
        while(pq.size() > 1){
            long a = pq.poll();
            long b = pq.poll();
            sum += a+b;
            pq.add(a+b);
        }
        return sum;
    }

}
