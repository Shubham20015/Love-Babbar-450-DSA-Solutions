package internship.heaps;

import java.util.*;

public class MaxInKsubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int res[] = maxInSubarray(arr, n, k);
		
		for(int val : res) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}
	
	static int[] maxInSubarray(int arr[],int n,int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int res[] = new int[n-k+1];
		
		if(k > n)
			return res;
		
		for(int i=0;i<k;i++) {
			pq.add(arr[i]);
		}
		
		for(int i=k;i<n;i++) {
			res[i-k] = pq.peek();
			if(arr[i] > pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		
		res[n-k] = pq.poll();
		
		return res;
	}
	

}
