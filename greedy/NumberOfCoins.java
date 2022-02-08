package internship.greedy;

import java.util.*;

public class NumberOfCoins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int totalMoney = sc.nextInt();
		int coins[] = new int[m];
		
		for(int i=0;i<m;i++)
			coins[i] = sc.nextInt();
		
		changeInIndianCurrency(totalMoney);
		System.out.println(minCoins(coins,m,totalMoney));
		
		sc.close();
	}
	
//	For Indian Currency
	 static int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
			  
	 static void changeInIndianCurrency(int V)
	{
			ArrayList<Integer> ans = new ArrayList<>();
			int n = deno.length;
			for (int i=n-1;i>=0;i--)
			     {
			         while (V >= deno[i]) 
			            {
			                V -= deno[i];
			                ans.add(deno[i]);
			            }
			      } 
			 for (int val : ans)
			            System.out.print(val + " ");
	}
	 
//	 For random given currency
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
