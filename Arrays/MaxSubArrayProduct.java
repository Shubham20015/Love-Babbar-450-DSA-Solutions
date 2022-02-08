package internship;

import java.util.*;

public class MaxSubArrayProduct {
	
//	                                               DOGE ALGORITHM
//1.  We traverse from i=0 till end and find the maximum product , whenever we encounter zero we make our product 1 and proceed.

//2.  Now, We traverse from i=n-1 till 0 and find the maximum product , whenever we encounter zero we make our product 1 and proceed.

//3.  Now take the max of these two

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int [n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		long l = 0,r = 0;
		long result = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			l = (l == 0 ? 1:l) * arr[i];
			r = (r == 0 ? 1:r) * arr[n-i-1];
			result = Math.max(result, Math.max(l, r));
		}
		
		System.out.println(result);
		
		sc.close();

	}

}
