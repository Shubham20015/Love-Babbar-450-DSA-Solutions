package internship;

import java.util.*;

public class MaxSumSubArray {
	
//	Remember the order of if condition
//	I use j and k variable to print max sum contigous subarray

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		int sum = 0,j = 0,k=0,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			sum += arr[i];
			if(sum>max) {
				max=sum;
				k=i+1;
			}
			if(sum < 0) {
				sum = 0;
				j = i+1;
			}
		}
		
		System.out.println(max);
		
		for(int i=j;i<k;i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}

}
