package internship.dynamicProgramming;

import java.util.Scanner;

public class SmallestSumContiguousSubarry {
	
	static int smallestSum(int arr[],int n) {
		int min = Integer.MAX_VALUE,sum = 0;
		for(int i=0;i<n;i++) {
			if(sum > 0) {
				sum = arr[i];
			}else {
				sum += arr[i];
			}
			min = Math.min(min, sum);	
		}
		
		return min;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Sum of smallest subarray: " + smallestSum(arr,n));
		
		sc.close();
	}

}
