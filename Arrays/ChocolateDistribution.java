package internship;

import java.util.*;

public class ChocolateDistribution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		long arr[] = new long[n];
		
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);
		
		long min = Integer.MAX_VALUE;
		
		for(int i=0;i<=n-m;i++) {
			min = Math.min(min, arr[i+m-1] - arr[i]);
		}
		
		System.out.println(min);
		
		sc.close();

	}

}
