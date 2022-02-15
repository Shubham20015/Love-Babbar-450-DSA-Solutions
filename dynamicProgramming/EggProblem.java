package internship.dynamicProgramming;

import java.util.Scanner;

public class EggProblem {
//	TC: O(N*(K^2)) , SC: O(N*K)
	static int eggDrop(int n, int k)  // Always select best out of worsts or min of maxes
	{
	    int dp[][] = new int[n+1][k+1];
	    
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=k;j++){
	            if(i == 1){
	                dp[i][j] = j;
	            }
	            else if(j == 1){
	                dp[i][j] = 1;
	            }
	            else{
	                int mini = Integer.MAX_VALUE;
	                for(int x=j-1,y=0;x>=0;x--,y++){
	                    int val = Math.max(dp[i][x],dp[i-1][y]);
	                    mini = Math.min(mini,val);
	                }
	                dp[i][j] = mini + 1;
	            }
	        }
	    }
	    
	    return dp[n][k];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println("Minimum attempts to find critical floor: " + eggDrop(n,k));
		
		sc.close();

	}

}
