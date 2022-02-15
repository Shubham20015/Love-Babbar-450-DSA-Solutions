package internship.dynamicProgramming;

import java.util.Scanner;

public class MaxSubsequenceSumNo3cons {
	
	static int maxSum(int n,int arr[]) {
		int dp[] = new int[n];
		
		if(n >= 1)
			dp[0] = arr[0];
		if(n >= 2)
			dp[1] = arr[0] + arr[1];
		if(n > 2)
			dp[2] = Math.max(dp[1],Math.max(arr[0] + arr[2], arr[1] + arr[2]));
			
		
		for(int i=3;i<n;i++) {
			dp[i] = Math.max(dp[i-3] + arr[i] + arr[i-1],Math.max(dp[i-1],dp[i-2] + arr[i]));
		}
		
		return dp[n-1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Maximum sum of subsequence selecting no 3 consecutive indexes: " + maxSum(n,arr));
		
		sc.close();
	}

}
