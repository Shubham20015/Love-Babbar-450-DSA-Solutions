package internship.greedy;

import java.util.Scanner;

public class MinNumberCoins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int total = sc.nextInt();
		int coins[] = new int[m];
		
		for(int i=0;i<m;i++) {
			coins[i] = sc.nextInt();
		}
		
		System.out.println(minCoins(coins,m,total));
		
		sc.close();
	}
//	TC: O(total*m) , SC: (total)
	static int minCoins(int coins[], int M, int V) 
	{ 
	    int dp[] = new int[V+1];
	    dp[0] = 0;
	    
	    for(int i=1;i<=V;i++)
	        dp[i] = Integer.MAX_VALUE;
	    
	    for(int i=1;i<=V;i++){
	        for(int j=0;j<M;j++){
	            if(coins[j] <= i){
	                int res = dp[i-coins[j]];
	                if(res != Integer.MAX_VALUE)
	                    dp[i] = Math.min(dp[i],res+1);
	            }
	        }
	    }
	    
	    return dp[V] == Integer.MAX_VALUE? -1 : dp[V];
	} 

}
