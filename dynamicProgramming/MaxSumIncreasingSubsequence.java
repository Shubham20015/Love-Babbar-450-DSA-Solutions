package internship.dynamicProgramming;

import java.util.Scanner;

public class MaxSumIncreasingSubsequence {
	
	static int maxSumIS(int arr[], int n)  
	{  
	    int dp[] = new int[n];
	    dp[0] = arr[0];
	    int ans = 0;
	    
	    for(int i=1;i<n;i++){
	        dp[i] = arr[i];
	        for(int j=0;j<i;j++){
	            if(arr[j] < arr[i]){
	                dp[i] = Math.max(dp[j]+arr[i],dp[i]);
	            }
	        }
	        
	        ans = Math.max(ans,dp[i]);
	    }
	    
	    return Math.max(dp[0],ans);
	}  

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Maximum sum of increasing subsequence: " + maxSumIS(arr,n));
		
		sc.close();
	}

}
