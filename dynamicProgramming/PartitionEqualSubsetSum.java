package internship.dynamicProgramming;

import java.util.Scanner;

public class PartitionEqualSubsetSum {
	
	static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        
        for(int i=0;i<N;i++){
            sum += arr[i];
        }
        
        if(sum % 2 != 0){
            return 0;
        }
        
        return solve(N,arr,sum/2) ? 1:0;
    }
    
    static boolean solve(int N,int arr[],int sum){
        boolean dp[][] = new boolean[N+1][sum+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(i == 0){
                    dp[i][j] = false;
                }
                else if(j == 0){
                    dp[i][j] = true;
                }
                else if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[N][sum];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Equal sum in partition subset: " + equalPartition(n, arr));
		
		sc.close();

	}

}
