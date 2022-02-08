package internship.stackQueue;

import java.util.*;

public class SumOfMaxMinOfKsize {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(calSum(arr,n,k));
		
		sc.close();
	}
	
	static int calSum(int arr[],int n,int k) {
		Deque<Integer> q1 = new LinkedList<>();
		Deque<Integer> q2 = new LinkedList<>();
		
		for(int i=0;i<k;i++) {
			
			while(!q1.isEmpty() && arr[q1.peekLast()] >= arr[i])
				q1.removeLast();
			while(!q2.isEmpty() && arr[q2.peekLast()] <= arr[i])
				q2.removeLast();
			
			q1.addLast(i);
			q2.addLast(i);
		}
		
		int sum = 0;
		
		for(int i=k;i<n;i++) {
			sum += arr[q1.peekFirst()] + arr[q2.peekFirst()];
			
			while(!q1.isEmpty() && q1.peekFirst() <= i-k)
				q1.removeFirst();
			while(!q2.isEmpty() && q2.peekFirst() <= i-k)
				q2.removeFirst();
			
			while(!q1.isEmpty() && arr[q1.peekLast()] >= arr[i])
				q1.removeLast();
			while(!q2.isEmpty() && arr[q2.peekLast()] <= arr[i])
				q2.removeLast();
			
			q1.addLast(i);
			q2.addLast(i);
		}
		sum += arr[q1.peekFirst()] + arr[q2.peekFirst()];
		
		return sum;
	}

}
