package internship.heaps;

import java.util.*;

public class KthLargestSumInContiguousSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k =sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
	
		System.out.println(KthLargestSum(arr, n, k));
		
		sc.close();

	}
	
//	TC: O(N^2logK) , SC: O(K) || O(N)
	static int KthLargestSum(int arr[],int n,int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int sum[] = new int[n+1];
		sum[0] = 0;
		sum[1] = arr[0];
		
		for(int i=2;i<=n;i++)
			sum[i] = sum[i-1] + arr[i-1];
		
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
				int x = sum[j] - sum[i-1];
				pq.offer(x);
				if(pq.size() > k)
					pq.poll();
			}
		}
		
		return pq.poll();
	}	
}
