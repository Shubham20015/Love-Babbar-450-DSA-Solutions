package internship.dynamicProgramming;

import java.util.*;

public class MinCostToFillBagWithGivenWeigh {
	
//	TC: O(N*W) , SC: O(N*W)
	static int minimumCost(int cost[], int N,int W)
	{
		int dp[][] = new int[N+1][W+1];
		for(int i=0;i<=N;i++)
		    Arrays.fill(dp[i],-1);
		return solve(dp,cost,N-1,W);
	}
	
	static int solve(int dp[][],int cost[],int n,int w){
	    if(n == -1 && w == 0)
	        return 0;
	    if(n == -1)
	        return (int)(1e+9);
	    if(w == 0)
	        return 0;
	    if(dp[n][w] != -1)
	        return dp[n][w];
	    
	    if(n+1 > w || cost[n] == -1) return dp[n][w] = solve(dp,cost,n-1,w);
	    
	    int x = cost[n] + solve(dp,cost,n,w-(n+1));
	    int y = solve(dp,cost,n-1,w);
	    
	    return dp[n][w] = Math.min(x,y);
	}
	
//	TC: O(N*W) , SC: O(N*W)
	static int minimumCostDPTable(int cost[], int N,int W)
	{
		int dp[][] = new int[N+1][W+1];
		for(int i=0;i<=N;i++){
		    for(int j=0;j<=W;j++){
		        if(i == 0){
		            dp[i][j] = Integer.MAX_VALUE;
		        }
		        else if(j == 0){
		            dp[i][j] = 0;
		        }
		        else if(cost[i-1] != -1 && i <= j && dp[i][j-i] != Integer.MAX_VALUE){
		            dp[i][j] = Math.min(cost[i-1] + dp[i][j-i],dp[i-1][j]);
		        }else{
		            dp[i][j] = dp[i-1][j];
		        }
		    }
		}
		
		return dp[N][W] == Integer.MAX_VALUE ? -1:dp[N][W];
	}
	
//	TC: O(N*W) , SC: O(W)
	static int minimumCostOptimisedDP(int cost[], int N,int W)
	{
		int dp[] = new int[W+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for(int i=1;i<=W;i++){
		    for(int j=1;j<=N;j++){
		        if(j <= i && cost[j-1] != -1 && dp[i-j] != Integer.MAX_VALUE)
		            dp[i] = Math.min(dp[i],cost[j-1] + dp[i-j]);
		    }
		}
		
		return dp[W] == Integer.MAX_VALUE ? -1:dp[W];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int cost[] = new int[n];
		
		for(int i=0;i<n;i++) {
			cost[i] = sc.nextInt();
		}
		
		System.out.println("Minimum cost to fill bag using memosiation: " + minimumCost(cost,n,w));
		System.out.println("Minimum cost to fill bag using tabulation: " + minimumCostDPTable(cost,n,w));
		System.out.println("Minimum cost to fill bag using optimised DP: " + minimumCostOptimisedDP(cost,n,w));
		
		sc.close();
	}

}
