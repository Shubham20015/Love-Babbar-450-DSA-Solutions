package internship.dynamicProgramming;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int n = sc.nextInt();
		int wt[] = new int[n];
		int val[] = new int[n];
		
		for(int i=0;i<n;i++) {
			wt[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			val[i] = sc.nextInt();
		}
		
		System.out.println(solve(W,wt,val,n-1));
		System.out.println(knapSack(W, wt, val, n) );
		
		sc.close();
	}
	
//	TC:O(2^n) , SC:O(recusion stack space)
	static int solve(int W, int wt[], int val[], int n){
        if(W == 0 || n == 0){
            return 0;
        }
        
        if(wt[n] > W){
            return solve(W,wt,val,n-1);
        }
        return Math.max(val[n]+solve(W-wt[n],wt,val,n-1),solve(W,wt,val,n-1));
    }
	
//	TC:O(n*m) , SC:O(n*m)
	static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],dp[i-1][j]); // max(select that item + remaining weight ans, ans if we dont select that item)
                }else{
                    dp[i][j] = dp[i-1][j];  // ans if we dont select that item as weight of item is higher than current weight required
                }
            }
        }
        
        return dp[n][W];
    }
}
