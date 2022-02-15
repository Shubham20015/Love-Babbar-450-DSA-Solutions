package internship.dynamicProgramming;

import java.util.*;

public class OptimalGameStrategy {
	
	static long countMaximum(int arr[], int n)
    {
        long dp[][] = new long[n][n];
        
        for(long rows[]: dp){
            Arrays.fill(rows,-1);
        }
        
        return maxSum(dp,arr,0,n-1);
    }
    
    static long maxSum(long dp[][],int arr[], int i,int j){
        if(i > j){
            return 0;
        }
        
        if(i == j){
            return arr[i];
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        long x = arr[i] + Math.min(maxSum(dp,arr,i+1,j-1),maxSum(dp,arr,i+2,j));
        long y = arr[j] + Math.min(maxSum(dp,arr,i+1,j-1),maxSum(dp,arr,i,j-2));
        
        return dp[i][j] = Math.max(x,y);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Maximum sum of value of coins first player get: " + countMaximum(arr, n));
		
		sc.close();
	}

}
