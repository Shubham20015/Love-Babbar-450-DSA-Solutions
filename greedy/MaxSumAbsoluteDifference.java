package internship.greedy;

import java.util.*;

public class MaxSumAbsoluteDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(maxDifference(arr, n));
		System.out.println(maxDiff(arr, n));
		
		sc.close();
	}
	
	static int maxDifference(int arr[],int n) {
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n/2;i++) {
			list.add(arr[i]);
			list.add(arr[n-i-1]);
		}
		
		  if (n % 2 != 0)
	            list.add(arr[n/2]);
		
		int sum = 0;
		for(int i=0;i<n-1;i++) {
			sum += Math.abs(list.get(i) - list.get(i+1));
		}
		sum += Math.abs(list.get(n-1) - list.get(0));
		return sum;
	}
	
	static int maxDiff(int arr[],int n) {
		Arrays.sort(arr);
			
		int sum = 0;
		for(int i=0;i<n/2;i++) {
			sum += Math.abs(arr[n-i-1] - arr[i]);
		}

		return sum*2;
	}

}
