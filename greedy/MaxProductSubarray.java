package internship.greedy;

import java.util.Scanner;

public class MaxProductSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(maxProduct(arr,n));
		
		sc.close();
	}
	
	static long maxProduct(int arr[],int n) {
		long prod = 1;
		int zeroCount = 0,negCount = 0;
		int maxNeg = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(arr[i] == 0) {
				zeroCount++;
				continue;
			}
			else if(arr[i] < 0) {
				maxNeg = Math.max(maxNeg, arr[i]);
				negCount++;
			}
			prod *= arr[i];
		}
		
		if(zeroCount == n)
			return 0;
		
		if(negCount % 2 == 1) {
			
			if(negCount == 1 && zeroCount > 0 && zeroCount + negCount == n) {
				return 0;
			}
			
			return prod/maxNeg;
		}
		
		return prod;
	}

}
