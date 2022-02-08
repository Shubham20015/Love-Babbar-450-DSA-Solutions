package internship.heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k =sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(kthSmallest(arr, k));
		System.out.println(kthLargest(arr, k));
		
		sc.close();
	}
//	TC: O(K + (N-K)logK) , SC: O(K)
	static int kthSmallest(int arr[],int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			pq.add(arr[i]);
			while(pq.size() > k) {
				pq.poll();
			}
		}
		
		return pq.poll();
	}
	
//	TC: O(K + (N-K)logK) , SC: O(K)
	static int kthLargest(int arr[],int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			pq.add(arr[i]);
			while(pq.size() > k) {
				pq.poll();
			}
		}
		
		return pq.poll();
	}

}
